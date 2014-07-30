pyg = 'ay'
bran = True
while(bran):
	original = raw_input('Enter an english word: ')
	if len(original) > 0 and original.isalpha():
		word = original.lower()
		first = word[0]
		if first == 'a' or first == 'e' or first == 'i' or first == 'o' or first == 'u':
			new_word = word + 'h' + pyg
		else:
			new_word = word[1:] + first + pyg
		print "\nPygLatin:              " + new_word + "\n\n\n"
