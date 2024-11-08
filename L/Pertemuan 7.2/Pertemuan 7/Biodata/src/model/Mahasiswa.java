package model;

// Mahasiswa.java
public class Mahasiswa {
    private int id;
    private String nama;
    private String npm;
    private Jurusan jurusan;
    private String alamat;
    private String noTelepon;

    public Mahasiswa(int id, String nama, String npm, Jurusan jurusan, String alamat, String noTelepon) {
        this.id = id;
        this.nama = nama;
        this.npm = npm;
        this.jurusan = jurusan;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNpm() { return npm; }
    public void setNpm(String npm) { this.npm = npm; }

    public Jurusan getJurusan() { return jurusan; }
    public void setJurusan(Jurusan jurusan) { this.jurusan = jurusan; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }
}
