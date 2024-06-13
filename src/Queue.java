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
        long nominalBayar =0;
        if (kendaraan.jenis.equalsIgnoreCase("Motor")) {
            if (kendaraan.cc <100) {
                nominalBayar = kendaraan.bulanHarusBayar*100000;
            }else 
            if(kendaraan.cc < 250){
                nominalBayar = kendaraan.bulanHarusBayar*250000;
            }else
            if(kendaraan.cc > 250 ){
                nominalBayar = kendaraan.bulanHarusBayar*500000;
            }
            
        }else
        if (kendaraan.jenis.equalsIgnoreCase("Mobil")) {
            if (kendaraan.cc <1000) {
                nominalBayar = kendaraan.bulanHarusBayar*1000000;
            }
        }else
        if (kendaraan.cc < 2500) {
            nominalBayar = kendaraan.bulanHarusBayar*1000000;
        }else
        if (kendaraan.cc > 2500) {
            nominalBayar = kendaraan.bulanHarusBayar*1500000;
        }

        // denda operation
        long denda = 0;
        if (bulanYgDibayarkan > kendaraan.bulanHarusBayar) {
            if (bulanYgDibayarkan - kendaraan.bulanHarusBayar <=3) {
                denda = 50000;
            }else
            if (bulanYgDibayarkan - kendaraan.bulanHarusBayar >3) {
                denda = (bulanYgDibayarkan-kendaraan.bulanHarusBayar)*50000;
            }
        }




        this.antriBayar[tail] = new TransaksiPajak(kode, nominalBayar, denda, bulanYgDibayarkan, kendaraan);
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