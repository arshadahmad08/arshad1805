'''
A 
B C 
D E F 
G H I J 
K L M N O 
'''
def char_pattern(args):   
    ascii_val = 65
    for i in range(0, args):   
        for j in range(0, i+1):         
            ch = chr(ascii_val)
            print(ch, end=" ")       
            ascii_val = ascii_val + 1    
        print("\r") 
char_pattern(5) 

'''
A 
B B 
C C C 
D D D D 
E E E E E
'''

def char_pattern(args):   
    ascii_val = 65
    for i in range(0, args):   
        for j in range(0, i+1):         
            ch = chr(ascii_val) 
            print(ch, end=" ")       
        ascii_val = ascii_val + 1    
        print("\r") 
char_pattern(5)
