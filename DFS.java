import java.util.*;

class DFS {
    int vertex;
    LinkedList<Character> list[];
    boolean[] diKunjungi;

    DFS(int v) {
        vertex = v;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
        diKunjungi = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            diKunjungi[i] = false;
        }
    }

    void tambahEdge(char edgeAwal, char edgeAkhir) {
        list[edgeAwal - 'A'].add(edgeAkhir);
    }

    void DFS(char sumber) {
        Stack<Character> stack = new Stack<>();
        stack.push(sumber);
        while (!stack.isEmpty()) {
            sumber = stack.peek();
            char current = stack.pop();
            int sumberIndex = current - 'A';
            
            if (diKunjungi[sumberIndex] == false){
                diKunjungi[sumberIndex] = true ;
                System.out.println(current);
            }
            Iterator<Character> iter = list[sumberIndex].listIterator();
            while (iter.hasNext()){
                char v = iter.next();
                int vIndex = v - 'A';
                if(!diKunjungi[vIndex]){
                    stack.push(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        DFS graph = new DFS(9);
        
        graph.tambahEdge('A', 'D');
        graph.tambahEdge('D', 'G');
        graph.tambahEdge('G', 'H');
        graph.tambahEdge('H', 'I');
        graph.tambahEdge('A', 'B');
        graph.tambahEdge('B', 'E');
        graph.tambahEdge('E', 'F');
        graph.tambahEdge('F', 'C');
        
        System.out.println();
        System.out.println("Hasil DFS :");
        graph.DFS('A');
        System.out.println();
        
    }
}
