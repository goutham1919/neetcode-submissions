class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length+B.length;
        int half = total/2;

        if(A.length>B.length){
            int[] temp = A;
            A=B;
            B=temp;
        }

        int l=-1;
        int r=A.length;


if (A.length == 0) {
    if (B.length % 2 == 1) {
        return B[B.length / 2];
    }

    return (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0;
}


        while(l<=r){
            int i = (l+r)/2;
            int j=half-i-2;

            int Aleft = (i>=0)?A[i]:Integer.MIN_VALUE;
            int Aryt= (i+1<A.length)?A[i+1]:Integer.MAX_VALUE;

            int Bleft = (j>=0)?B[j]:Integer.MIN_VALUE;
            int Bryt= (j+1<B.length)?B[j+1]:Integer.MAX_VALUE;

            if(Aleft<=Bryt && Bleft<=Aryt){
                if(total%2==1){
                    double res = Math.min(Aryt,Bryt);
                    return res;
                }else{
                    double res= (Math.max(Aleft,Bleft)+Math.min(Aryt,Bryt))/2.0;
                    return res;
                }
            }else if(Aleft>Bryt){
                r=i-1;
            }else{
                l=i+1;
            }
        }

        return -1.0;
    }
}