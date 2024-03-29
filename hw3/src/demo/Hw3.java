package demo;

import java.util.Scanner;


public class Hw3 {
    public static class Point{
        private int vertical;
        private int horizontal;
        public  Point(){
            this.vertical = 0;
            this.horizontal = 0;
        }
        public void Set(int vertical, int horizontal){
            this.vertical = vertical;
            this.horizontal = horizontal;
        }
        public void Move(int vertical, int horizontal){
            this.vertical += vertical;
            this.horizontal += horizontal;
        }
        public void Rotate(){
            int temp = this.horizontal;
            this.horizontal = -this.vertical;
            this.vertical = temp;
        }
        public int RetrieveVertical(){
            return this.vertical;
        
        }
        public int RetrieveHorizontal(){
            return this.horizontal;
        }
        public int calculateManhattanDistance(Point point){
            return Math.abs(this.vertical - point.vertical) + Math.abs(this.horizontal - point.horizontal);
        }
        public double ChebyshevDistance(Point other){
            return Math.max(Math.abs(this.vertical - other.vertical), Math.abs(this.horizontal - other.horizontal));
        }
    
    }
    public static Point Init(int x,int y){
        Point point = new Point();
        point.Set(x, y);
        return point;
    }
    public static void main(String[] args) {
        int x,y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt(); y = scanner.nextInt();
        Point p1 = Init(x,y);
        x = scanner.nextInt(); y = scanner.nextInt();
        Point p2 = Init(x,y);
        x = scanner.nextInt(); y = scanner.nextInt();
        scanner.close();
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        p1.Move(x,y);
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        p1.Rotate();
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        p1.Rotate();
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        p1.Rotate();
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        p1.Rotate();
        System.out.println(p1.RetrieveVertical() + " " + p1.RetrieveHorizontal());
        System.out.println(p1.calculateManhattanDistance(p2));
        System.out.println(p1.ChebyshevDistance(p2));

    }
}
