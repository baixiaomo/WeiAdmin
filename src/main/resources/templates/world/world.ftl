<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
<#import "../base.ftl" as base>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的微世界</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!--导入样式-->
<@base.styles></@base.styles>
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
<#--<@base.header></@base.header>-->
    <!-- Left side column. contains the logo and sidebar -->
<#--<@base.leftSideBar></@base.leftSideBar>-->
    <!-- Content Wrapper. Contains page content -->
<@base.model2 activeButton='worldbutton'>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                世界
                <!--<small>Optional description</small>-->
            </h1>
            <!-- <ol class="breadcrumb">
               <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
               <li class="active">Here</li>
             </ol>-->
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->

        </section>
        <!-- /.content -->

    </div>
    <!-- /.content-wrapper -->
</@base.model2>
    <!-- Main Footer -->
<#--<@base.footer></@base.footer>-->
    <!-- Control Sidebar -->
<#--<@base.rightSideBar></@base.rightSideBar>-->
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
<#--<div class="control-sidebar-bg"></div>-->
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<@base.js></@base.js>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>