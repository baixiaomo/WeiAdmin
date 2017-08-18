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
<@base.model1 activeButton='filemanager'>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                FileManager
                <small>Version 2.0</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#filelist" data-toggle="tab"><span class="fa fa-file-o margin-r-5"></span>文章列表</a></li>
                            <li ><a href="#fileedit" data-toggle="tab"><span class="fa fa-edit margin-r-5"></span>文章编辑</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="filelist">
                                filelist
                            div class="tab-pane" id="fileedit">
                                <div class="box box-info">
                                    <div cl</div>
                                <ass="box-header">
                                        <h3 class="box-title">CK Editor
                                            <small>Advanced and full of features</small>
                                        </h3>
                                        <!-- tools box -->
                                        <div class="pull-right box-tools">
                                            <button type="button" class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip"
                                                    title="Collapse">
                                                <i class="fa fa-minus"></i></button>
                                            <button type="button" class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip"
                                                    title="Remove">
                                                <i class="fa fa-times"></i></button>
                                        </div>
                                        <!-- /. tools -->
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body pad">
                                        <form>
				                    <textarea id="editor1" name="editor1" rows="10" cols="80">
				                                            This is my textarea to be replaced with CKEditor.
				                    </textarea>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div><!--./tab-content-->
                    </div>
                </div>

            </div>


        </section>
        <!-- /.content -->

    </div>
    <!-- /.content-wrapper -->
</@base.model1>

</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<@base.js></@base.js>
<script src="./bower_components/ckeditor/ckeditor.js"></script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<script>
    $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('editor1')
        //bootstrap WYSIHTML5 - text editor
        //$('.textarea').wysihtml5()
    })
</script>
</body>
</html>