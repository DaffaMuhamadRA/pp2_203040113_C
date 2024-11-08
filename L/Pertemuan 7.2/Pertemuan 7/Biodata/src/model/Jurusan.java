package model;

public class Jurusan {
    private int id;
    private String Jurusan_nama;

    public Jurusan(int id, String Jurusan_nama) {
        this.id = id;
        this.Jurusan_nama = Jurusan_nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJurusan_nama() {
        return Jurusan_nama;
    }

    public void setJurusan_nama(String Jurusan_nama) {
        this.Jurusan_nama = Jurusan_nama;
    }
}
