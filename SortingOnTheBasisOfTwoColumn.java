//Sorting based on column2 (ascending)

 Arrays.sort(arr, (a,b)-> {
            if(a[1] == b[1]){
                return a[0] - b[0];
         }
         return a[1] - b[1];
  });
//Sorting based on column2 (descending)

Arrays.sort(arr, (a,b)-> {
            if(b[1] == a[1]){
                return b[0] - a[0];
         }
         return b[1] - a[1];
  });

//converting ArrayList to Array
list.toArray(new int[row.length][col.length]);
