<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <div class="jumbotron">
            <form method="post" class="form-horizontal">
                <c:set var="knife" value="${knife}"/>
                <div class="form-group">
                    <label for="name" class="control-label col-sm-3">Name:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${knife.name}" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="control-label col-sm-3">Price:</label>
                    <div class="col-sm-4">
                        <input type="number" min="0.01" step="0.01" class="form-control"
                               id="price" name="price" value="${knife.price}" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="imageURL" class="control-label col-sm-3">Image URL:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="imageURL" name="imageURL"
                               value="${knife.imageURL}" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <input type="submit" class="btn btn-danger" value="Delete"/>
                    </div>
                </div>
            </form>
        </div>
    </main>
</div>
