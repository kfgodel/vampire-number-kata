##Challenge:
Given a number, detect and show all of the vampire numbers between 0 and that given number

Vampire Number - Fang1 * Fang2
Rule 1: A vampire number must have an even number of digits
Rule 2: Each fang must be half the number of digits as the vampire number
Rule 3: All of the digits in the vampire number must be distributed among the fangs
Rule 4: A trailing zero is only allowed in one fang

Example: 1260 = 21 * 60


## Translating the rules to myself
Rule 1: If an integer number has even count of digits => It is a fangable number
Rule 3: A fangable number can have many sets of fangs (each for possible digit permutation)
Rule 2: A set of fangs has two numbers with half of the digits of the original number (with possibly different digit order) 
Rule 4: If only one of the fangs has a trailing 0 => It is an asymmetrical set of fangs
Rule 5: If fangable number == fang1 * fang2 => It is fangable product
Rule 6: If fangable asymmetrical set of fangs and fangable product => vampire number