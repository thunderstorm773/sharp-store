<div class="container">
    <main>
        <div class="jumbotron">
            <form method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">Name:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name"
                               name="name" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="control-label col-sm-3">Price:</label>
                    <div class="col-sm-4">
                        <input type="number" min="0.01" step="0.01" class="form-control"
                               id="price" name="price" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="imageURL" class="control-label col-sm-3">Image URL:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="imageURL" name="imageURL"
                               required/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <input type="reset" class="btn btn-danger" value="Clear"/>
                        <input type="submit" class="btn btn-success" value="Add"/>
                    </div>
                </div>
            </form>
        </div>
    </main>
</div>
