# Portofolio GUI Java Swing

## Deskripsi
Project ini merupakan aplikasi GUI (Graphical User Interface) sederhana menggunakan Java Swing. Aplikasi menampilkan halaman portofolio pribadi yang berisi daftar keahlian. Pengguna dapat mengklik salah satu keahlian untuk melihat halaman detailnya, kembali ke halaman utama, dan membuka dialog kontak.

Aplikasi ini dibuat untuk memenuhi latihan materi GUI Java dengan menerapkan Top Level Container, Intermediate Component, Atomic Component, Layout Manager, dan Event Handling.

## Teknologi
- Java
- Java Swing
- AWT (Abstract Window Toolkit)

## Struktur File

| File | Fungsi |
|---|---|
| `Main.java` | Jendela utama (`JFrame`) sekaligus pengatur perpindahan halaman dengan `CardLayout`. |
| `Portofolio.java` | Halaman utama berisi sambutan, daftar keahlian, dan tombol kontak. |
| `Detail.java` | Halaman detail yang menampilkan deskripsi keahlian yang dipilih. |
| `Theme.java` | Menyimpan konstanta warna dan font agar tampilan seragam di semua halaman. |

## 1. Top Level Container

Top Level Container merupakan komponen utama yang berfungsi sebagai wadah untuk menampilkan komponen GUI lainnya.

Pada project ini, Top Level Container yang digunakan adalah `JFrame` dan `JDialog`.

Implementasi:

```java
public class Main extends JFrame
```

```java
JDialog dialog = new JDialog(mainApp, "Kontak", true);
```

`Main` mewarisi `JFrame` sebagai jendela utama aplikasi. Sementara itu, `JDialog` digunakan untuk dialog Kontak yang bersifat modal, artinya pengguna harus menutup dialog terlebih dahulu sebelum dapat berinteraksi kembali dengan jendela utama.

Beberapa method yang digunakan:
- `super("Portofolio Saya")` untuk mengatur judul jendela.
- `setSize()` untuk mengatur ukuran jendela.
- `setDefaultCloseOperation()` untuk mengatur tindakan ketika jendela ditutup (`EXIT_ON_CLOSE` pada `JFrame` dan `DISPOSE_ON_CLOSE` pada `JDialog`).
- `setLocationRelativeTo()` untuk menempatkan jendela di tengah layar (atau di tengah jendela utama untuk dialog).
- `setVisible(true)` untuk menampilkan jendela.

## 2. Intermediate Component

Intermediate Component merupakan komponen yang berfungsi sebagai wadah untuk mengelompokkan komponen GUI lainnya.

Pada project ini, komponen yang digunakan adalah `JPanel`.

Implementasi:

```java
panelRowKeahlian = new JPanel(new GridLayout(1, 3, 15, 0));
```

`JPanel` digunakan dalam dua cara:
- Sebagai halaman. Class `Portofolio` dan `Detail` sama-sama mewarisi `JPanel`, sehingga dapat dipasang sebagai halaman di dalam `Main`.
- Sebagai pembungkus. Panel seperti `panelWelcome`, `panelKeahlian`, `panelRowKeahlian`, `panelContact`, `panelJudul`, `panelDeskripsi`, dan `panelBack` digunakan untuk mengelompokkan label dan tombol agar tersusun rapi.

Selain itu, digunakan `setBorder()` dengan `BorderFactory` untuk memberikan jarak antara komponen dan tepi panel, serta untuk membuat garis tepi biru pada tombol keahlian.

## 3. Atomic Component

Atomic Component merupakan komponen GUI yang digunakan untuk menampilkan informasi atau menerima input pengguna.

Komponen yang digunakan dalam project ini meliputi:

| Komponen | Fungsi |
|---|---|
| `JLabel` | Menampilkan judul sambutan, subjudul "Daftar Keahlian", judul detail, deskripsi keahlian, dan nomor kontak. |
| `JButton` | Menjalankan tindakan ketika diklik, yaitu tombol keahlian, Contact Me, OK, dan Back. |

Contoh implementasi:

```java
JButton b = new JButton(teks);
b.setFont(Theme.TOMBOL);
b.setBackground(Theme.PUTIH);
b.setForeground(Theme.BIRU);
b.setFocusPainted(false);
b.setBorder(BorderFactory.createLineBorder(Theme.BIRU, 3));
```

Pada halaman detail, deskripsi ditampilkan dalam `JLabel` menggunakan teks HTML sehingga dapat rata tengah dan turun baris otomatis:

```java
labelDeskripsi.setText("<html><div style='text-align:center; width:520px;'>"
        + deskripsi + "</div></html>");
```

## 4. Layout Manager

Layout Manager berfungsi mengatur posisi dan ukuran komponen GUI secara otomatis di dalam container.

Project ini menggunakan empat jenis Layout Manager:

### a. BorderLayout

```java
setLayout(new BorderLayout(0, 10));
add(panelWelcome, BorderLayout.NORTH);
add(panelKeahlian, BorderLayout.CENTER);
add(panelContact, BorderLayout.SOUTH);
```

`BorderLayout` mengatur komponen berdasarkan lima area, yaitu NORTH, SOUTH, EAST, WEST, dan CENTER. Pada halaman `Portofolio`, judul sambutan diletakkan di NORTH, daftar keahlian di CENTER, dan tombol Contact Me di SOUTH. Pada dialog Kontak, pesan diletakkan di CENTER dan tombol OK di SOUTH.

### b. GridLayout

```java
panelRowKeahlian = new JPanel(new GridLayout(1, 3, 15, 0));
```

`GridLayout(1, 3, 15, 0)` membagi panel menjadi 1 baris dan 3 kolom dengan jarak horizontal 15 piksel, sehingga tiga kotak keahlian (Coding, Project Management, Writing) berukuran sama dan tersusun sejajar.

### c. FlowLayout

```java
panelWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER));
```

`FlowLayout` menyusun komponen secara berurutan dan dirata tengah. Layout ini digunakan pada panel pembungkus judul, deskripsi, dan tombol agar komponen berada di tengah.

### d. GridBagLayout

```java
setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
c.gridx = 0;
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 1.0;
```

`GridBagLayout` digunakan pada halaman `Detail` untuk menyusun tiga baris (judul, deskripsi, tombol Back). Nilai `weighty = 1.0` hanya diberikan pada baris terakhir sehingga seluruh sisa ruang vertikal dipakai baris tersebut, dan `anchor = NORTH` menjaga tombol Back tetap berada di atas sel.

### e. CardLayout (perpindahan halaman)

```java
cardLayout = new CardLayout();
containerHalaman = new JPanel(cardLayout);

containerHalaman.add(portofolioPanel, "PORTOFOLIO");
containerHalaman.add(detailKeahlianPanel, "DETAIL");

cardLayout.show(containerHalaman, "PORTOFOLIO");
```

`CardLayout` menumpuk beberapa panel dan hanya menampilkan satu panel pada satu waktu. Layout ini digunakan di `Main` untuk berpindah antara halaman Portofolio dan halaman Detail tanpa membuka jendela baru.

## 5. Event Handling

Event Handling merupakan mekanisme untuk menangani tindakan pengguna, seperti klik tombol.

Pada project ini, Event Handling menggunakan `ActionListener` yang ditulis dengan ekspresi lambda.

### a. Event pada Halaman Portofolio

```java
btnCoding.addActionListener(e -> this.mainApp.bukaDetailKeahlian("Coding",
        "Terbiasa membangun aplikasi dengan Java, termasuk antarmuka Swing dan penerapan konsep OOP."));
```

Ketika salah satu tombol keahlian diklik, program memanggil method `bukaDetailKeahlian()` pada `Main` dengan membawa judul dan deskripsi keahlian. Method tersebut mengisi data ke halaman `Detail` melalui `setDataKeahlian()`, lalu menampilkan halaman tersebut dengan `cardLayout.show()`.

```java
btnContact.addActionListener(e -> tampilkanDialogKontak());
```

Ketika tombol Contact Me diklik, program menampilkan dialog modal "Kontak" yang berisi nomor kontak. Dialog ditutup dengan tombol OK (`dialog.dispose()`).

### b. Event pada Halaman Detail

```java
btnBack.addActionListener(e -> this.mainApp.bukaPortofolio());
```

Ketika tombol Back diklik, program memanggil `bukaPortofolio()` pada `Main` untuk kembali ke halaman Portofolio.

## 6. Dua Interface yang Digunakan

### a. Portofolio

Halaman utama yang menampilkan judul "Selamat Datang di Portofolio Saya", daftar tiga keahlian (Coding, Project Management, Writing), dan tombol Contact Me. Klik pada kotak keahlian membuka halaman Detail, sedangkan tombol Contact Me membuka dialog kontak.

### b. Detail

Halaman yang menampilkan judul dan deskripsi dari keahlian yang dipilih. Isi halaman ini berubah sesuai tombol yang diklik di halaman Portofolio. Tombol Back digunakan untuk kembali ke halaman Portofolio.

Kedua interface diimplementasikan menggunakan class Java yang berbeda, yaitu `Portofolio` dan `Detail`, yang masing-masing mewarisi `JPanel` dan ditampilkan secara bergantian di dalam satu `JFrame` (`Main`).

## 7. Kelas Pendukung: Theme

Class `Theme` menyimpan konstanta warna dan font yang dipakai bersama oleh seluruh halaman, sehingga tampilan konsisten dan mudah diubah dari satu tempat.

| Konstanta | Nilai |
|---|---|
| `BIRU` | Warna biru tua (0, 51, 102) |
| `KUNING` | Warna kuning (255, 204, 0) |
| `PUTIH` | Warna putih |
| `HITAM` | Warna hitam |
| `JUDUL` | Arial Bold 28 |
| `SUBJUDUL` | Arial Bold 22 |
| `NORMAL` | Arial Plain 16 |
| `TOMBOL` | Arial Bold 16 |

## 8. Cara Menjalankan Program

Pastikan Java JDK telah terpasang dan keempat file (`Main.java`, `Portofolio.java`, `Detail.java`, `Theme.java`) berada di folder yang sama.

Compile program:

```bash
javac Main.java Portofolio.java Detail.java Theme.java
```

Jalankan program:

```bash
java Main
```

## 9. Kesimpulan

Project Portofolio GUI ini menerapkan konsep dasar pembuatan antarmuka menggunakan Java Swing. `JFrame` dan `JDialog` digunakan sebagai Top Level Container, `JPanel` sebagai Intermediate Component, komponen seperti `JLabel` dan `JButton` sebagai Atomic Component, serta `BorderLayout`, `GridLayout`, `FlowLayout`, `GridBagLayout`, dan `CardLayout` sebagai Layout Manager. Interaksi pengguna ditangani menggunakan `ActionListener` dengan ekspresi lambda.

Aplikasi ini masih berupa tampilan statis karena data keahlian dan nomor kontak ditulis langsung di dalam kode dan tidak menggunakan database.
