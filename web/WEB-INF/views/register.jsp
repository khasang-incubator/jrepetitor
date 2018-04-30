<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/sticky-footer-navbar.css" rel="stylesheet">
    <link href="css/text.css" rel="stylesheet">
    <title>Jrepetitor</title>
</head>
<body>
<header class="container">
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">Fixed navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<main role="main" class="container-fluid ">
    <div class=".col-12 col-md-5 col-xs-5" id="content" style="float: none; margin: 0 auto;">
        <li class="list-group">
        <li class="list-group-item active">
            <div class="b">Register New User</div>
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Name:</div>
            <div class="d-inline p-2 error-text" id="name-error-place">name-error-place</div>
            <input type="text" class="form-control" id="name-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Surname:</div>
            <div class="d-inline p-2 error-text" id="surname-error-place">surname-error-place</div>
            <input type="text" class="form-control" id="surname-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Middlename:</div>
            <div class="d-inline p-2 error-text" id="middlename-error-place">middlename-error-place</div>
            <input type="text" class="form-control" id="middlename-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Phone:</div>
            <div class="d-inline p-2 error-text" id="phone-error-place">phone-error-place</div>
            <input type="text" class="form-control" id="phone-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Email:</div>
            <div class="d-inline p-2 error-text" id="email-error-place">email-error-place</div>
            <input type="text" class="form-control" id="email-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Login:</div>
            <div class="d-inline p-2 error-text" id="login-error-place">login-error-place</div>
            <input type="text" class="form-control" id="login-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Password:</div>
            <div class="d-inline p-2 error-text" id="password-input-place">password-error-place</div>
            <input type="text" class="form-control" id="password-input">
        </li>
        <li class="list-group-item">
            <div class="d-inline p-2 b">Confirm password:</div>
            <div class="d-inline p-2 error-text" id="сonfirm-password-error-place">password-error-place</div>
            <input type="text" class="form-control" id="сonfirm-password-input">
        </li>

        <li class="list-group-item button button-place">
            <div class="d-inline p-2 button btn-md " id="first-button-field">
                <button onclick="SendForm()" type="button" class="btn btn-primary showFormButton">Create</button>
            </div>
            <div class="d-inline p-2 button btn-md " id="second-button-field">
                <button onclick="clearForm()" type="button" class="btn btn-primary showFormButton">Clear form</button>
            </div>
        </li>
        </ul>
    </div>
</main>

<footer class="footer">
    <div class="container"></div>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src=js/register.js></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
</script>
</body>