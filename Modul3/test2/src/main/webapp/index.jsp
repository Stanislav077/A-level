<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="/resources/js/js.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link href="resources/css/css.css" rel="stylesheet" media="screen" />
</head>
<body>


<header>
    <nav>
        <ul class="create">
            <li>
                <input id="create_table" type="button" value="Create Table">
            </li>
            <li>
                <label  for="colum"> Colum</label>
                <input name="colums" id="colum" type="text"/>
            </li>
            <li>
                <label for="rows"> Row</label>
                <input name="rows" id="rows" type="text"/>
            </li>
            <li>
                <input id="save_table" type="button" value="Save Table">
            </li>

        </ul>

    </nav>
</header>

<form id="form_table" method="post" action="">
<div class="resoult"></div>
</form>
<div style="display: none" class="sing_form">
    <form id="form_action" action="/account" method="post">
        <div class="input_form">
            <label for="names" >Name</label>
            <input id="nm" name="name" id="names" type="text" />
            <p id="error">Error</p>
        </div>
        <div class="input_form">
            <label for="emais" >Email</label>
            <input name="email" id="emails" type="text" />
        </div>
        <div class="input_form">
            <label for="passwords">Password</label>
            <input name="pass" id="passwords" type="text" />
        </div>
        <div class="input_form">
            <label for="confirms">Confirm</label>
            <input name="confirm" id="confirms" />
        </div>
        <input class="btn"  type="submit" />

    </form>
</div>
</body>
</html>
