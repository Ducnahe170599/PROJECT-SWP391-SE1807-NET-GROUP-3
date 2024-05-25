<%-- 
    Document   : lesson-detail
    Created on : May 25, 2024, 4:23:41 PM
    Author     : Admin
--%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <title>Course Detail</title>
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap"
            rel="stylesheet">
        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
              integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- End Head -->
    </head>

    <body>
        <div class="page d-flex">
            <style>
                /* Reset CSS */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Heebo', sans-serif;
                background-color: #f0f2f5;
                color: #333;
                line-height: 1.6;
            }

            

            /* Content */
            .content {
                width: 80%;
                /*margin-left: 270px;*/
                margin: 0 auto;
                padding: 20px;
                min-height: 100vh;
                background-color: #f4f4f4;
            }

            /* Content Header */
            .content h1 {
                font-size: 28px;
                color: #007bff;
                margin-bottom: 20px;
            }

            /* Profile Page */
            .profile-page {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                margin-bottom: 20px;
            }

            /* Overview */
            .overview {
                display: flex;
                align-items: flex-start;
                flex-wrap: wrap;
            }

            .avatar-box {
                text-align: center;
                padding: 20px;
                flex: 1;
                max-width: 300px;
            }

            .avatar-box img {
                width: 160px;
                height: 100px;
                border-radius: 20px;
                object-fit: cover;
                margin-bottom: 10px;
            }

            .avatar-box h3 {
                margin: 10px 0;
                font-size: 18px;
                color: #333;
            }

            .avatar-box p {
                color: #777;
            }

            .level {
                background-color: #eee;
                border-radius: 6px;
                overflow: hidden;
                height: 10px;
                margin-top: 10px;
            }

            .level span {
                display: block;
                height: 100%;
                background-color: #007bff;
            }

            .rating i {
                color: #ff9800;
                font-size: 16px;
            }

            /* Information Box */
            .info-box {
                width: 100%;
                padding: 20px;
                flex: 2;
            }

            .info-box .box {
                display: flex;
                flex-wrap: wrap;
                margin-bottom: 20px;
            }

            .info-box .box h4 {
                width: 100%;
                margin-bottom: 10px;
                font-size: 16px;
                color: #777;
            }

            .info-box .box .info-item {
                flex: 1;
                margin-right: 10px;
                color: #555;
                margin-bottom: 10px;
            }

            .info-box .box .info-item span {
                display: block;
                color: #333;
            }

            .info-box .box .info-item span.c-grey {
                color: #777;
            }

            /* Buttons */
            .label {
                display: inline-block;
                padding: 8px 16px;
                border-radius: 4px;
                font-size: 14px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .bg-green {
                background-color: #28a745;
            }

            .bg-red {
                background-color: #dc3545;
            }

            .c-white {
                color: #fff;
            }

            .bg-green:hover {
                background-color: #218838;
            }

            .bg-red:hover {
                background-color: #c82333;
            }

            @media (max-width: 768px) {
                .content {
                    width: 100%;
                    margin: 0 auto;
                    margin-left: 0;
                    padding: 10px;
                }

                .overview {
                    flex-direction: column;
                }

                .avatar-box {
                    margin: 0 auto;
                }

            }
            </style>

            <div>

                <div class="content w-full">
                    <!-- Start Head -->
                    <div>

                        <h1 class="p-relative">Details of Course Head First Java by Kathy Sierra &</h1>
                        <div class="profile-page m-20">
                            <!-- Start Overview -->
                            <div class="overview bg-white rad-10 d-flex align-center">
                                <div class="avatar-box txt-c p-20">
                                    <img class="course-img"
                                         src="../images/subjects/cea201.png" alt="" />
                                    <h3 class="m-0">Head First Java by Kathy Sierra &</h3>
                                    <p class="c-grey mt-10">Programing</p>
                                    <div class="level rad-6 bg-eee p-relative">
                                        <span style="width: 70%"></span>
                                    </div>
                                    <div class="rating mt-10 mb-10">
                                        <i class="fa-solid fa-star c-orange fs-13"></i>
                                        <i class="fa-solid fa-star c-orange fs-13"></i>
                                        <i class="fa-solid fa-star c-orange fs-13"></i>
                                        <i class="fa-solid fa-star c-orange fs-13"></i>
                                        <i class="fa-solid fa-star c-orange fs-13"></i>
                                    </div>
                                    <p class="c-grey m-0 fs-13 mt-10">
                                       <span class="label btn-shape bg-green c-white">Active</span>
                                    </p>
                                </div>
                                <div class="info-box w-full txt-c-mobile">
                                    <div class="box p-20 d-flex align-center">
                                        <h4 class="c-grey fs-15 m-0 w-full">General Information</h4>
                                        <div class="fs-14 info-item">
                                            <span class="c-grey">Course Name:</span>
                                            <span>Head First Java by Kathy Sierra &</span>
                                        </div>
                                        <div class="fs-14 info-item">
                                            <span class="c-grey">Category:</span>
                                            <span>Programing</span>
                                        </div>
                                    </div>
                                    <div class="info-btn" style="margin-bottom: 20px;">
                                        <div class="fs-14 info-item">
                                            <span class="c-grey">Public:</span>
                                            <span>2023-08-30</span>
                                        </div>
                                        <div class="fs-14 info-item">
                                            <span class="c-grey">Duration:</span>
                                            <span>2.0</span>
                                        </div>
                                    </div>
                                    <!-- End Information Row -->
                                    <!-- Start Information Row -->
                                    <div class="box p-20 d-flex align-center">
                                        <h4 class="c-grey w-full fs-15 m-0">Details Information</h4>

                                        <div class="fs-14 info-item">
                                            <span class="c-grey">Description:</span>
                                            <span>Java is a widely-used programming language for coding web applications. It
                                                has been a popular choice among developers for over two decades, with
                                                millions of Java applications in use today. Java is a multi-platform,
                                                object-oriented, and network-centric language that can be used as a platform
                                                in itself.</span>
                                        </div>
                                    </div>
                                    <form action="ChangeStatusCourse" method="post">
                                        <div class="box p-20 d-flex align-center">
                                            <input value="0" name="courseid" hidden="">
                                            <input value="true" name="status" hidden="">
                                            <div class="fs-14">
                                                <button class="label btn-shape bg-red c-white" type="button"
                                                        onclick="confirmBan()">Reject</button>
                                            </div>
                                            <script>
                                                function confirmBan() {
                                                    if (confirm("Are you sure with this change?")) {
                                                        document.forms[0].submit();
                                                    } else {
                                                        alert("Changes not saved.");
                                                    }
                                                }
                                            </script>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>

</html>