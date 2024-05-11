package com.example.lab2_ph31990

import java.util.*

class SinhVien(
    var ten: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)

class QuanLySinhVien {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun addSinhVien() {

        val scanner = Scanner(System.`in`)

        println("----- Thêm sinh viên -----")
        print("Nhập tên sinh viên: ")
        val ten = scanner.nextLine()
        print("Nhập MSSV: ")
        val mssv = scanner.nextLine()
        print("Nhập điểm TB: ")
        val diemTB = scanner.nextFloat()
        print("Sinh viên đã tốt nghiệp? (true/false): ")
        val daTotNghiep = scanner.nextBoolean()
        print("Nhập tuổi: ")
        val tuoi = scanner.nextInt()

        val sinhVien = SinhVien(ten, mssv, diemTB, daTotNghiep, tuoi)

        danhSachSinhVien.add(sinhVien)
        println("Thêm sinh viên thành công: ${sinhVien.ten}")
    }

    fun deleteSinhVien(mssv: String) {
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }
        if (sinhVien != null) {
            danhSachSinhVien.remove(sinhVien)
            println("Xóa sinh viên thành công: $mssv")
        } else {
            println("Không tìm thấy MSSV: $mssv")
        }
    }

    fun DanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên trống.")
        } else {
            println("----- Danh sách sinh viên -----")
            danhSachSinhVien.forEach { sinhVien ->
                println("MSSV: ${sinhVien.mssv}")
                println("Tên: ${sinhVien.ten}")
                println("Điểm TB: ${sinhVien.diemTB}")
                println("Tuổi: ${sinhVien.tuoi ?: "Null"}")
                println("Tốt nghiệp: ${sinhVien.daTotNghiep ?: "Null"}")
                println("-----------------------------")
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val quanLySV = QuanLySinhVien()

    var choose: Int
    do {
        println("----- MENU -----")
        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Xem danh sách sinh viên")
        println("0. Thoát")
        print("Nhập lựa chọn: ")

        try {
            choose = scanner.nextInt()
            scanner.nextLine()
            when (choose) {
                1 -> quanLySV.addSinhVien()
                2 -> {
                    println("----- Xóa sinh viên -----")
                    print("Nhập MSSV cần xóa: ")
                    val mssv = scanner.nextLine()
                    quanLySV.deleteSinhVien(mssv)
                }
                3 -> {
                    println("----- Danh sách sinh viên -----")
                    quanLySV.DanhSachSinhVien()
                }
                0 -> {
                    println("Thoát chương trình.")
                }
                else -> {
                    println("Vui loòng nhạp laại")
                }
            }
        } catch (e: InputMismatchException) {
            println("Nhập lại:")
            scanner.nextLine()
            choose = -1
        }
    } while (choose != 0)

    scanner.close()
}
