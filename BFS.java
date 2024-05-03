import java.util.*;

class BFS{ 
    int nodes ;
    LinkedList<Character> list[];
    Queue<Character> vertexQueue ;

    public BFS(int vertex){
        nodes = vertex;
        list = new LinkedList[vertex];

        for(int i = 0 ; i < vertex ; i++){
            list[i] = new LinkedList<>();
        }
        vertexQueue = new LinkedList<Character>();
    }
    public void tambahEdge(char edgeAwal,char edgeAkhir){
        list[edgeAwal - 'A'].add(edgeAkhir);
    }
    public void BFS(char sumber){
        boolean checkerVertex[] = new boolean[26];
        int counter = 0;
        checkerVertex[sumber - 'A'] = true ;
        vertexQueue.add(sumber);

        while(!vertexQueue.isEmpty()){
            char current = vertexQueue.poll();
            counter = current - 'A';
            if(list[counter].isEmpty()){
                continue ;
            }else{
                System.out.println( current + "-->" + list[counter] + " ");
            }
            for(char tetangga : list[counter]){
                if(!checkerVertex[tetangga - 'A']){
                    checkerVertex[tetangga - 'A'] = true ;
                    vertexQueue.add(tetangga);
                }
            }
        }
    }
    public static void main(String[] args){
        BFS graph = new BFS(9);
        // Tambahkan edge dengan huruf
        graph.tambahEdge('A', 'B');
        graph.tambahEdge('A', 'D');
        graph.tambahEdge('A', 'E');
        graph.tambahEdge('D', 'G');
        graph.tambahEdge('E', 'F');
        graph.tambahEdge('G', 'H');
        graph.tambahEdge('F', 'C');
        graph.tambahEdge('H', 'I');
        // Jalankan BFS dari titik 'A'
        graph.BFS('A');
    }
}