class Solution {
    int start, end, n;
    List<int[]> list;
    public int[][] insert(int[][] arr, int[] newI) {
        start = newI[0];
        end = newI[1];
        n = arr.length;
        list = new ArrayList<>();
        
        int low = 0;
        int high = n - 1;
        int s = -1, e = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid][0] <= start){
                s = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        low = 0; high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid][1] >= end){
                e = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        forest(list, arr, s, e);
        int size = list.size();
        int ans[][] = new int[size][];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
    void forest(List<int[]> list, int[][] arr, int s, int e){
        int extra[] = new int[2];
        if(s == -1){
            extra[0] = start;
            if(e == -1){
                extra[1] = end;
                list.add(extra);
                return;
            }
            else{
                if(end < arr[e][0]){
                    extra[1] = end;
                    list.add(extra);
                    add(e, arr.length - 1, arr);
                    return;
                }
                else{
                    extra[1] = arr[e][1];
                    list.add(extra);
                    add(e + 1, arr.length - 1, arr);
                    return;
                }
            }
        }
        else{
            add(0, s - 1, arr);
            if(start > arr[s][1]){
                list.add(arr[s]);
                extra[0] = start;
                if(e == -1){
                    extra[1] = end;
                    list.add(extra);
                    return;
                }
                else{
                    if(end < arr[e][0]){
                        extra[1] = end;
                        list.add(extra);
                        add(e, n - 1, arr);
                        return;
                    }
                    else{
                        extra[1] = arr[e][1];
                        list.add(extra);
                        add(e + 1, n - 1, arr);
                        return;
                    }
                }
            }
            else{
                extra[0] = arr[s][0];
                if(s == e){
                    add(s, n - 1, arr);
                    return;
                }
                else if(e == -1){
                    extra[1] = end;
                    list.add(extra);
                    return;
                }
                else if(end < arr[e][0]){
                    extra[1] = end;
                    list.add(extra);
                    add(e, n - 1, arr);
                    return;
                }
                else{
                    extra[1] = arr[e][1];
                    list.add(extra);
                    add(e + 1, n - 1, arr);
                    return;
                }
            }
        }
    }
    void add(int low, int high, int[][] arr){
        while(low <= high){
            list.add(arr[low++]);
        }
    }
}