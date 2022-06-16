<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Y TẾ</title>
</head>
<body>
<form:form method="POST" action="/declaration" modelAttribute="declaration">

<h2>TỜ KHAI Y TẾ</h2>

<p>Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng chống dịch
    bệnh truyền nhiềm </p>

<p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

<div>
    <div>
        <label>Họ tên(Ghi chữ IN HOA)</label>
        <form:input path="name"/>
    </div>

    <div>
        <div>
            <label>Năm sinh</label>
            <form:select path="dayOfBirth">
                <form:options items="${listDayOfBirth}"/>
            </form:select>

            <label>Giới tính</label>
            <form:select path="gender">
                <form:option value="Nam">Nam</form:option>
                <form:option value="Nữ">Nữ</form:option>
            </form:select>

            <label>Quốc tịch</label>
            <form:select path="nationality">
                <form:options items="${listNationality}"/>
            </form:select>
        </div>

        <div>
            <label>Số hộ chiếu hoặc CMND</label>
            <form:input path="idCard"/>
        </div>

        <div>
            <label>Thông tin đi lại</label>
            <form:radiobuttons path="vehicle" items="${listVehicle}"/>
        </div>

        <div>
            <label>Số hiệu phương tiện</label>
            <form:input path="idVehicle"/>
            <label>Số ghế</label>
            <form:input path="chair"/>
        </div>

        <div>
            <label>Ngày khởi hành</label>
            <form:input type="date" path="dayComeBack"/>
            <label>Ngày kết thúc</label>
            <form:input type="date" path="dayComeOut"/>
        </div>

        <div>
            <label>Trong vòng 14 ngày, Anh/chị có đến tỉnh thành nào không?</label>
            <form:textarea path="reason"/>
        </div>

        <div>
            <input type="submit" value="Gửi tờ khai">
        </div>
    </div>
    </form:form>
</body>
</html>
