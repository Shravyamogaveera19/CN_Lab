// Bellman Ford Algorithm to find the shortest path from source
import java.util.*;

class Bellman_Ford{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        
        int[][] graph = new int[n][n];

        System.out.println("Enter the cost matrix (Use 0 for no edge):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source node(Indexing from 1):");
        int source = sc.nextInt();

        BellmanFord(source-1,graph,n);
    }

    public static void BellmanFord(int source,int[][] graph,int n){

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i = 0; i < n-1; i++){
            for(int u = 0; u < n; u++){
                for(int v = 0 ;v < n; v++){
                    if(graph[u][v] != 0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

            for(int u = 0; u < n; u++){
                for(int v = 0 ;v < n; v++){
                    if(graph[u][v] != 0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                        System.out.println("Negative weight Detected");
                        return ;
                    }
                }
            }
        PrintSolution(n,dist);
    }
    
    public static void PrintSolution(int n,int[] dist){
        
        System.out.println("vertex \t Distance\n");
        for(int i=0; i<n;i++){
            System.out.println((i+1) + "\t\t" + (dist[i] == Integer.MAX_VALUE? "Infinity" : dist[i]));
        }
    }
}
