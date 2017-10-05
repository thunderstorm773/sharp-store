<div class="container">
    <main>
        <div class="jumbotron">
            <form class="form-horizontal" method="post">
                <div class="form-group">
                    <label for="username" class="control-label col-sm-3">Username:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="username"
                               id="username" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label col-sm-3">Password:</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" name="password"
                               id="password" required/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <input type="reset" class="btn btn-danger" value="Clear"/>
                        <input type="submit" class="btn btn-primary" value="Login"/>
                    </div>
                </div>
            </form>
        </div>
    </main>
</div>
