class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        a = 0 
        b = 0 
        c = 0 

        for i in bills:
            
            if i == 5 :
                a+=1
                continue 

            elif i == 10:
                b+=1
                if a > 0:
                    a-=1
                    continue
                else:
                    return False 
            else:
                c+=1 
                if a > 2 or (a > 0 and b > 0):
                    if a > 0 and b > 0:
                        a -= 1 
                        b -= 1
                    else:
                        a -= 3
                        

                    continue
                else:
                    return False

        return True 
        