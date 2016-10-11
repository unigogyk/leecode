problem 136:
Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

异或的性质：
恒等律：X ⊕ 0 = X 
归零律：X ⊕ X = 0

（1）交换律
A ⊕ B = B ⊕ A

（2）结合律
A ⊕ (B ⊕ C) = (A ⊕ B) ⊕ C

综上：
A ⊕ B ⊕ B = A ⊕ 0 = A