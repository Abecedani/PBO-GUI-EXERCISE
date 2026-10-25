# Login & Register GUI Java Swing

## Deskripsi
Project ini merupakan aplikasi GUI (Graphical User Interface) sederhana menggunakan Java Swing. Aplikasi memiliki dua interface, yaitu Login dan Register. Pengguna dapat mendaftarkan username dan password, kemudian menggunakan akun tersebut untuk login.

Aplikasi ini dibuat untuk memenuhi latihan materi GUI Java dengan menerapkan Top Level Container, Intermediate Component, Atomic Component, Layout Manager, dan Event Handling.

## Teknologi
- Java
- Java Swing
- AWT (Abstract Window Toolkit)


## 1. Top Level Container

Top Level Container merupakan komponen utama yang berfungsi sebagai wadah untuk menampilkan komponen GUI lainnya.

Pada project ini, Top Level Container yang digunakan adalah `JFrame`.

Implementasi pada kedua interface:

```java
public class LoginApp extends JFrame
```

```java
public class RegisterApp extends JFrame
```

Kedua class mewarisi `JFrame` sehingga dapat menampilkan jendela aplikasi secara mandiri.

Beberapa method JFrame yang digunakan:
- `setTitle()` untuk mengatur judul jendela.
- `setSize()` untuk mengatur ukuran jendela.
- `setDefaultCloseOperation()` untuk mengatur tindakan ketika jendela ditutup.
- `setLocationRelativeTo(null)` untuk menempatkan jendela di tengah layar.
- `setVisible(true)` untuk menampilkan jendela.

## 2. Intermediate Component

Intermediate Component merupakan komponen yang berfungsi sebagai wadah untuk mengelompokkan komponen GUI lainnya.

Pada project ini, komponen yang digunakan adalah `JPanel`.

Implementasi:

```java
JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
```

`JPanel` digunakan untuk mengelompokkan label, kolom input, dan tombol pada halaman Login maupun Register agar tersusun rapi.

Selain itu, digunakan `setBorder()` untuk memberikan jarak antara komponen dan tepi panel.

## 3. Atomic Component

Atomic Component merupakan komponen GUI yang digunakan untuk menampilkan informasi atau menerima input pengguna.

Komponen yang digunakan dalam project ini meliputi:

| Komponen | Fungsi |
|---|---|
| `JLabel` | Menampilkan teks Username dan Password. |
| `JTextField` | Menerima input username. |
| `JPasswordField` | Menerima input password dengan karakter tersembunyi. |
| `JButton` | Menjalankan tindakan ketika diklik. |
| `JOptionPane` | Menampilkan pesan informasi atau kesalahan. |

Contoh implementasi:

```java
JLabel lblUsername = new JLabel("Username:");
JTextField txtUsername = new JTextField();
JLabel lblPassword = new JLabel("Password:");
JPasswordField txtPassword = new JPasswordField();
JButton btnLogin = new JButton("Login");
```

Komponen-komponen tersebut digunakan pada kedua interface dengan fungsi yang disesuaikan.

## 4. Layout Manager

Layout Manager berfungsi mengatur posisi dan ukuran komponen GUI secara otomatis di dalam container.

Project ini menggunakan dua jenis Layout Manager:

### a. GridLayout

```java
JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
```

`GridLayout(4, 2, 10, 10)` membagi panel menjadi 4 baris dan 2 kolom, dengan jarak horizontal dan vertikal masing-masing 10 piksel.

Layout ini digunakan agar label, input, dan tombol tersusun dalam bentuk baris dan kolom.

### b. BorderLayout

```java
add(panel, BorderLayout.CENTER);
```

`BorderLayout` mengatur komponen berdasarkan lima area, yaitu NORTH, SOUTH, EAST, WEST, dan CENTER. Pada project ini, panel diletakkan di area CENTER agar mengisi bagian utama jendela.

## 5. Event Handling

Event Handling merupakan mekanisme untuk menangani tindakan pengguna, seperti klik tombol.

Pada project ini, Event Handling menggunakan `ActionListener`.

### a. Event pada Login

```java
btnLogin.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.equals(usernameTerdaftar)
                && password.equals(passwordTerdaftar)
                && !usernameTerdaftar.isEmpty()) {
            JOptionPane.showMessageDialog(
                LoginApp.this,
                "Login berhasil! Selamat datang, " + username
            );
        } else {
            JOptionPane.showMessageDialog(
                LoginApp.this,
                "Username atau password salah!"
            );
        }
    }
});
```

Ketika tombol Login diklik, program mengambil username dan password yang dimasukkan pengguna, lalu membandingkannya dengan data akun yang tersimpan. Program menampilkan pesan berhasil jika sesuai atau pesan kesalahan jika tidak sesuai.

### b. Event pada Register

Tombol Daftar memiliki Event Handling untuk memeriksa input pengguna. Jika username atau password kosong, program menampilkan pesan kesalahan. Jika keduanya terisi, data disimpan ke variabel `static` pada class `LoginApp`, kemudian pengguna diarahkan ke halaman Login.

Tombol Register pada halaman Login digunakan untuk membuka halaman Register. Sementara itu, tombol Kembali pada halaman Register digunakan untuk kembali ke halaman Login.

## 6. Dua Interface yang Digunakan

### a. LoginApp

Interface Login digunakan untuk memasukkan username dan password yang sudah didaftarkan. Interface ini memiliki tombol Login untuk memeriksa kecocokan data dan tombol Register untuk membuka halaman pendaftaran.

### b. RegisterApp

Interface Register digunakan untuk membuat akun baru dengan memasukkan username dan password. Setelah pendaftaran berhasil, pengguna akan diarahkan kembali ke halaman Login.

Kedua interface diimplementasikan menggunakan class Java yang berbeda, yaitu `LoginApp` dan `RegisterApp`, dan masing-masing mewarisi `JFrame`.

## 7. Cara Menjalankan Program

Pastikan Java JDK telah terpasang dan kedua file berada di folder yang sama.

Compile program:

```bash
javac LoginApp.java RegisterApp.java
```

Jalankan program:

```bash
java LoginApp
```

## 8. Kesimpulan

Project Login & Register GUI ini menerapkan konsep dasar pembuatan antarmuka menggunakan Java Swing. `JFrame` digunakan sebagai Top Level Container, `JPanel` sebagai Intermediate Component, komponen seperti `JLabel`, `JTextField`, `JPasswordField`, dan `JButton` sebagai Atomic Component, serta `GridLayout` dan `BorderLayout` sebagai Layout Manager. Interaksi pengguna ditangani menggunakan `ActionListener`.

Aplikasi ini masih berupa simulasi sederhana karena data akun disimpan sementara di variabel `static` dan tidak menggunakan database. Data akan hilang ketika aplikasi ditutup.
