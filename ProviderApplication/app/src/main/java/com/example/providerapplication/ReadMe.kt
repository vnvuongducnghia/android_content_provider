package com.example.providerapplication

/**
 * Created by ${nghia.vuong} on 21,July,2021
 */

/*
ProviderApp cho phép thêm món ăn vào database của mình.
RequestApp được phép truy cập vào database các món ăn trong ProviderApp.

ProviderApp được cấu hình contentProvider để RequestApp truy cập database.
Để tạo một contentProvider chúng ta cần:
1. Tạo sub class cho ContentProvider.
2. Định nghĩa content URL.
3. Hiện thực các phương thức chưa hoàn chỉnh là insert(), update(), query(), delete(), getType().
4. Khai báo contentProvider trong AndroidManifest.xml

Thiết lập URl cho contentProvider, URL gồm 4 phần: [tiền tố content://][quyền][đường dẫn][id]
Mỗi URL đại điện cho một dataSet. content://authority/path/id

authority: Một java nameSpace của contentProvider hiện thực.
path: Một thư mục ảo trên trong provider cái này xác định loại dữ liệu được yêu cầu.
id: Là phần tùy chọn, nó chỉnh định primary key của record được yêu cầu. Chúng ta có thể bỏ qua phần này để yêu cầu tất cả record.

Đăng ký contentProvider với AndroidManifest.xml. Bằng từ khóa <provider> bên trong tag <application>
 <provider
     android:name=".MyProvider"
     android:authorities="com.example.contentproviderexample.MyProvider"
     android:exported="true"
     android:multiprocess="true" >
</provider>
Ở đây authorities là phần URL authority để truy cập content provider. Thông thường phần này là đường dẫn đầy đủ đến class content provider.


* */