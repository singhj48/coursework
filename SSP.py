from random import randint, sample
from itertools import chain, combinations
from time import time

class SSP():
    #initializing an SSP instance
    def __init__(self, S=[2,3,5,7,12,45,67,89,123,456,13,25,36,47,48,89,676,90,125,1], t=121):
        self.S = S # set of positive integers
        self.t = t # target value
        self.n = len(S) #Number of elements in the set
        #
        self.decision = False
        self.total    = 0  #
        self.selected = [] #Set of selected subsets

    def __repr__(self):
        #Print out the SSP instance in a readable form 
        return "SSP instance: S="+str(self.S)+"\tt="+str(self.t)

    #Random Construction Methods
    #===========================

    def random_instance(self, n, bitlength=10):
        #Builds a random SSP instance with set S and target t 
        max_n_bit_number = 2**bitlength-1
        self.S = sorted( [ randint(0, max_n_bit_number) for i in range(n) ] , reverse=True)
        self.t = randint(0,n*max_n_bit_number)
        self.n = len( self.S )

    def random_yes_instance(self, n, bitlength=10):
        #Build a random 'yes' instance with a set S and target t 
        #target t is the sum of a random sample subset of the set S 
        max_n_bit_number = 2**bitlength-1
        self.S = sorted( [ randint(0,max_n_bit_number) for i in range(n) ] , reverse=True)
        self.t = sum( sample(self.S, randint(0,n)) )
        self.n = len( self.S )


    def try_at_random(self):
        #Build an instance that generates a solution randomly
        candidate = []
        total = 0
        while total != self.t:
            candidate = sample(self.S, randint(0,self.n))
            total     = sum(candidate)
            print( "Trying: ", candidate, ", sum:", total )
            
##Solution methods 
# =================

#1 Exhaustive Search
#======================

    def exhaustive_search(self):
        if self.t == 0:
            return True
        for r in range (2, self.n):
            #it divides the set to make for easy lookup
            #it then checks all the combinations that can be found
            #taking one part before the other
            #iterate over all possible subsets
            for subsett in combinations(self.S,r):
                if sum(subsett) == self.t:
                    return True
        return False
    
#2 Dynamic Search
#================
    def dynamic(self, SUM, SET ):
        if SUM == 0:
            return True
        if(len(SET) > 1):
            for i in range(len(SET)):
                #takes the first item and checks against the next consecutive items
                    if(SET[0] + SET[i] == SUM):
                        #print("matched combination=%d %d", myset[0], myset[i])
                            return True
                        #it recursively performs another search on the set
                    if(self.dynamic( SUM, SET[1:])):                        
                            return True
        return False

#3Greedy Method
#==============

    def greedy_algorithm(self):
        total = 0 #initialize the total to zero
        subsets = []
        instance.random_instance
        for i in range(0, len(self.S)): #for every items that are in the set
            if (sum(subsets) + self.S[i]<= self.t):
                subsets.append(self.S[i])
                total = total + self.S[i]
            else:
                return(self.t - total) #return the difference between the target and the total of the selected subset
                break
        return subsets #return the subset



instance = SSP()

##Testing 
#========
#code adapted from sample code on module
def report_print( file, line ):
    print( line )
    file.write( line + '\n' )
 
# This would test the exhaustive search and generate the time graph it take with n from len(10) till its time limit of 60mins has elasped
def time_Exhaustive():
    with open("exhaustive.csv","w") as f:
        # test exhaustive search
        report_print( f, "n\tExhaustive" ) # header
        max_repeats = 100
        n  = 10
        t0 = t1 = 0
        while t1-t0 < 3600: # in seconds; if it takes too long then stop testing
            t0 = time()
            for repeats in range(max_repeats): # e.g. average over 100 instances
                instance.random_yes_instance(n) 
                decision = instance.exhaustive_search()#change the name here
            t1 = time()
            # record average time
            report_print( f, str(n)+"\t"+str((t1-t0)/max_repeats) )
            n += 1
time_Exhaustive()
           
#instance.dynamic(SUM,SET)
#print (instance)
#print (instance.dynamic(instance.t,instance.S))
