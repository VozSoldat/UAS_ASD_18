/**
 * Queue
 */
public class Queue {
    TransaksiPajak[] antriBayar = new TransaksiPajak[10];
    int head = 0;
    int tail = 0;
    int size = 0;

    Queue(int head, int tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public void enqueue(Kendaraan kendaraan, int bulanYgDibayarkan){
        int kode = 1;

        // nominal operation
        if (kendaraan.jenis.equals("Motor")) {
            if (kendaraan.cc <100) {
                long nominalBayar = kendaraan.bulanHarusBayar*100000;
            }else 
            if(kendaraan.cc < 250){
                long nominalBayar = kendaraan.bulanHarusBayar*250000;
            }else
            if(kendaraan.cc > 250 ){
                long nominalBayar = kendaraan.bulanHarusBayar*500000;
            }
            
        }
        this.antriBayar[tail] = new TransaksiPajak(kode, nominalBayar, bulanYgDibayarkan, bulanYgDibayarkan, kendaraan);
        tail++;
        size++;
        kode++;
    }
    
    public void dequeue(){
        head++;
        size--;
    }

    public void search(String noTNKB){
        for (int i = 0; i < size; i++) {
            if (antriBayar[i].kendaraan.noTNKB.equals(noTNKB)) {
                System.out.println("Data Kendaraan: \n" + antriBayar[i].kendaraan);
            }else{
                System.out.println("");
            }
        }
    }

}