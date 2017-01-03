from random import randint, sample
from itertools import chain, combinations
from time import time

class SSP():
    def __init__(self, S=[], t=0):
        self.S = S
        self.t = t
        self.n = len(S)
        #
        self.decision = False
        self.total    = 0
        self.selected = []

    def __repr__(self):
        return "SSP instance: S="+str(self.S)+"\tt="+str(self.t)
    
    def random_instance(self, n, bitlength=10):
        max_n_bit_number = 2**bitlength-1
        self.S = sorted( [ randint(0,max_n_bit_number) for i in range(n) ] , reverse=True)
        self.t = randint(0,n*max_n_bit_number)
        self.n = len( self.S )

    def random_yes_instance(self, n, bitlength=10):
        max_n_bit_number = 2**bitlength-1
        self.S = sorted( [ randint(0,max_n_bit_number) for i in range(n) ] , reverse=True)
        self.t = sum( sample(self.S, randint(0,n)) )
        self.n = len( self.S )

    ###

    def try_at_random(self):
        candidate = []
        total = 0
        while total != self.t:
            candidate = sample(self.S, randint(0,self.n))
            total     = sum(candidate)
            print( "Trying: ", candidate, ", sum:", total )
            
    #as array size gets bigger computation takes exponentially long
    ##brute force algor
    
    
    """
    BRUTE FORCE ALGORITHM
    definition of the problem - decision probelm
    
    complexity of problem - NP
    
    testing methodology - run the code x amount of times each with a different
    array size. calulate the average time it takes to compute the funtion as the
    array size increases


    """

    def subsetsum(self):
            def sum1 (array,n, num):
                if (num == 0):
                     return True
                if (n == 0 and num != 0):
                     return False
                if array[n-1] > num:
                        return sum1(array, n-1, num)
                return sum1(array, n-1, num) or sum1(array,n-1, num- array[n-1])
            return sum1(self.S, self.n, self.t)



    ##DYNAMIC less memory more time? but it will be betting brute force (?) e
    ##evaluate this in the coursework 









            


    ##greedy algotithm - stop looking for perfect solution, consider ways of getting a good solution
    ## not perfect but good
    ## optimisation probelm - making it better somehow - coursework




    #-----------------------------TIPS-----------------------#
        
    ##code
    ##evaluate and see how close it gets investigate scientifically and report on
    ##run x amount of tests (decent amount)
    ##be scientific, find averages
    ## tetsing method ---- end 100ins


#----------------------------------------------------------------------#  
instance = SSP()
for n in range(10,30):
    start_time = time()
    for repeats in range(100):
        instance.random_instance(n)
        ## return t/f
        instance.subsetsum()
        #generate time 
        #for i in range(100):
        #    "%d\t%6f" % (n,(time() - start_time)/100)

    print("%s\t%s" % (n,(time() - start_time)/100))

#------------------------------------------------------------------------#
