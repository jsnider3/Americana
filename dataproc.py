
with open('datadump.txt') as src:
  lines = src.readlines()
  entries = []
  for line in lines:
    entries += line.split('),(')
  print('Winner, Loser')
  for entry in entries:
    entry = entry.strip('),(;\n')
    fields = entry.split(',')
    winner = fields[1]
    countries = fields[2:4]
    if winner == "1":
      countries = [countries[1], countries[0]]
    print(', '.join(countries))
