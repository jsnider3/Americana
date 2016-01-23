'''

  @author: Josh Snider
'''
from subprocess import Popen, PIPE

NUM_COUNTRIES = 197

def get_countries():
  ''' Read in the list of countries. '''
  with open('countrylist.txt') as src:
    lines = src.readlines()
    lines = [line.strip() for line in lines]
    return lines

def get_matches():
  ''' Read in the list of match results. '''
  with open('csvlog.csv') as src:
    lines = src.readlines()
    lines = lines[1:]
    for line in lines:
      match = line.strip().split(', ')
      yield match

def make_csv():
  ''' Take a sqldump and make it into a simplified csv file.'''
  with open('datadump.txt') as src:
    with  open('csvlog.csv', 'w') as dest:
      lines = src.readlines()
      entries = []
      for line in lines:
        entries += line.split('),(')
      dest.write('Result, First, Second\n')
      for entry in entries:
        entry = entry.strip('),(;\n')
        fields = entry.split(',')
        winner = fields[1]
        countries = fields[1:4]
        dest.write(', '.join(countries) + "\n")

def make_elo():
  ''' Make a script that can be run with ruby to get
      the ratings. '''
  with  open('eloscript', 'w') as f:
    f.write("require 'elo'\n")
    for n in range(NUM_COUNTRIES):
      f.write('c' + str(n) + " = Elo::Player.new\n")
    for match in get_matches():
      if match[0] == "0":
        f.write('c' + str(match[1]) + '.plays_draw(c' + str(match[2]) + ')\n')
      elif match[0] == "1":
        f.write('c' + str(match[2]) + '.wins_from(c' + str(match[1]) + ')\n')
      elif match[0] == "-1":
        f.write('c' + str(match[1]) + '.wins_from(c' + str(match[2]) + ')\n')
    for n in range(NUM_COUNTRIES):
      f.write('c' + str(n) + ".rating\n")

def run_elo():
  ''' Run the Elo script and returns a list of countries sorted
      by Elo ranking. '''
  process = Popen(["irb", "eloscript"], stdout=PIPE)
  (output, err) = process.communicate()
  lines = output.split('\n')
  while "c0.rating" not in lines[0]:
    lines = lines[1:]
  lines = lines[:len(lines)-2]
  countries = get_countries()
  mapping = []
  country = None
  for line in lines:
    line = line[line.index('>') + 2:]
    line = line.strip()
    if 'rating' in line:
      country = countries[int(line[1:line.index('.')])]
    else:
      mapping.append((int(line), country))
  mapping = reversed(sorted(mapping))
  mapping = ([(1776, "USA (United States of America")] +
    [country for country in mapping if "USA" not in country[1]])
  return mapping

def print_elo_java(mapping):
  for entry in mapping:
    print('      ranks.put("' + entry[1] + '", ' + str(entry[0]) + ');')

def print_elo_md(mapping):
  print('Rank | Country | Elo Rating')
  print('---- |   ----  | ----')
  index = 1
  for entry in mapping:
    print(str(index) + " | " + entry[1] + " | " + str(entry[0]))
    print('---- | ---- | ----')
    index += 1

if __name__ == '__main__':
  make_csv()
  make_elo()
  print_elo_java(run_elo())
