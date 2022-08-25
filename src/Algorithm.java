import java.io.*;
import java.util.Scanner;


public class Algorithm {
    public float[] input(float[] arr) { // hàm nhập giá trị input
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Input number of elements: ");
            n = sc.nextInt();
        }
        while (n < 0 );
        System.out.print("Input  elements: ");
        arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
        }
        return arr;
    }

    // hàm viết giá trị nhập vào file
    public void writeFile(float[] arr,String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; ++i) {
                fw.write(arr[i] + "\n");
            }
            fw.flush();

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
    // hàm đọc file
    public void readFile(String fileName) {
        System.out.println("Read from file");
        System.out.print("Array a: ");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                System.out.print(line + " ");
                line = reader.readLine();
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        System.out.println(" ");
    }
    // hàm in giá trị mảng b
    public void printArr(float b[]) {
        for (int k = 0; k < b.length; ++k) {
            System.out.print(b[k] + " ");
            System.out.print(" ");
        }
        System.out.println();
    }
    // hàm sắp xếp nổi bọt
    public float[] bubbleSort(float arr[], boolean printR) {
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, arr.length);// copy mảng arr sang mảng b
        System.out.println("Bubble sort");
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    // hoán đổi arr[j+1] và arr[i]
                    float temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
            if (printR == true) {// cho phép in mảng b
                printArr(b);
            }
        }
        return b;
    }
    // hàm hoán đổi chô hmaf sắp xếp chọn
    public void swap(float arr[], int i, int j) {
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public float [] selectionSort(float arr[]) { // Hàm selection sort
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, arr.length);// copy mảng arr sang mảng b
        System.out.println("selection sort");
        int i, j, min_idx;
        // Di chuyển ranh giới của mảng đã sắp xếp và chưa sắp xếp
        for (i = 0; i < b.length - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
            min_idx = i;
            for (j = i + 1; j < b.length; j++)
                if (b[j] < b[min_idx])
                    min_idx = j;
            // Đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên
            swap(b, min_idx, i);
                printArr(b);
        }
        return b;
    }
    public float [] insertionSort(float arr[]) {// ham sap xep chen
        float[] b = new float[arr.length];
        System.arraycopy(arr, 0, b, 0, arr.length);
        int n = b.length;
        for (int i = 1; i < n; ++i) {
            float key = b[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;
            printArr(b);

        }
        return b;
    }
    // hàm viết kết quả vào file sau khi tìm kiếm
    public void writeFileSearch(String index,String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
                fw.write(index);
                fw.flush();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
    // hàm tìm kiếm tuyến tính
    public String search(float arr[]) {
        System.out.println("Linear Search");
        System.out.print("Input value:");
        Scanner sc = new Scanner(System.in);
        float value = sc.nextFloat();
        String index ="";
        // method search
            System.out.print("Chi so la: ");
            for ( int i = 0; i < arr.length; i++) {
                if (arr[i] > value) {
                    System.out.print(i+" ");
                     index += i +" ";
                }
            }
            System.out.println();
        return index;
        }
    // hàm tìm kiếm nhị phân
    public String binarySearch(float arr[]) {
        System.out.println("Binary Search");
        System.out.print("Input value: ");
        Scanner sc = new Scanner(System.in);
        float x = sc.nextFloat();
        float[] b = bubbleSort(arr, false);// gọi hàm bubbleSort để lấy mảng b đã sắp xếp, không cho in kết quả mnagr b
        String index ="";
        int l = 0, r = b.length - 1;
        int m = 0;
        while (l < r) {
            m =  (l + r) / 2;
            // Nếu x lớn hơn, bỏ qua nửa bên trái
            if (b[m] < x) {
                l = m + 1;
            }
            // Nếu x nhỏ hơn, bỏ qua nửa bên phải
            else {
                r = m - 1;
            }
        }
        // kiểm tra xem x có ở chính giữa không
            if (b[l] == x) {
                index += l+"";
            } else if (b[m] == x) {
                index += m+"";
            }
            System.out.println("Indext of first element: " + index);
        return index;
    }
}


