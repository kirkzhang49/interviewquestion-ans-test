class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        if (numRows ==0) return tri;
        for (int i=0;i<numRows;i++)//i is row number 
        {
            List<Integer> row = new ArrayList<>();
            for (int j=0;j<i+1;j++)// j is the cols in row
            {
                if (j==0||j==i)//start or end is one
                    row.add(1);
                else
                {
                    row.add(tri.get(i-1).get(j-1)+tri.get(i-1).get(j));
                }
            }
            tri.add(row);//after col iteration add  row to list
        }
        return tri; 
    }
}