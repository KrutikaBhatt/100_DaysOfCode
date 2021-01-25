"""
Given two strings string1 and string2 (named large and small), find the smallest substring in string1 containing all characters of string2 in O(n). You need to return the output substring.
Note : The characters of string2 need not to be present in same order in string1. That is, we need a substring which contains all characters of string2 irrespective of the order.
Return null if no substring with all characters is present.

Example :

Input -
    large = Looks for minimum string
    small =mums

Output -
    mum s

"""


import sys

def Find_smallest_Substring(large,small):
    if len(large) ==0:
        return None
    
    #Creating a dictionary to store the freq of charachters
    hashMap = dict()
    
    for i in range(len(small)):
        if small[i] in hashMap:
            hashMap[small[i]] = 1+hashMap[small[i]]
        else:
            hashMap[small[i]] = 1
            
    ansStart =0
    ansEnd = -1
    ansLength = sys.maxsize
    
    currentSubStart =0
    currentSubEnd =0
    
    remain = len(hashMap)
    
    while(currentSubEnd < len(large)):
        current = large[currentSubEnd]
        
        currentFreq = -sys.maxsize-1
        
        if current in hashMap:
            currentFreq = hashMap[current]
        if currentFreq == -sys.maxsize-1:
            currentSubEnd+=1
        else:
            hashMap[current] = currentFreq-1
            
            if currentFreq == 1:
                remain-=1;
                
            if remain ==0:
                while(currentSubStart <= currentSubEnd ):
                    ch = large[currentSubStart]
                    freq = -sys.maxsize-1
                    
                    if ch in hashMap:
                        freq = hashMap[ch]
                        
                    if freq == -sys.maxsize-1:
                        currentSubStart+=1
                        
                    elif freq<0:
                        currentSubStart+=1
                        hashMap[ch] = freq+1
                        
                    else:
                        currentSubLength = currentSubEnd - currentSubStart +1
                        
                        if ansLength > currentSubLength:
                            ansStart = currentSubStart
                            ansEnd = currentSubEnd
                            ansLength = currentSubLength
                        break
            currentSubEnd +=1
    if ansLength == sys.maxsize:
        return None
    else:
        return large[ansStart :ansEnd+1]
        
                        
                        

large = input().strip()
small = input().strip()

value = Find_smallest_Substring(large,small)

if (value == None):
    print(None)
else:
    print(value)