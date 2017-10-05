<div class="container">
    <main>
        <div class="jumbotron">
            <form method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="personName" class="control-label col-sm-3">Name:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="personName"
                               name="personName" placeholder="Name" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone-number" class="control-label col-sm-3">Phone Number:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="phone-number"
                               name="phoneNumber" placeholder="Phone Number" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="control-label col-sm-3">Address:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="address"
                               name="address" placeholder="Address" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="deliveryType" class="control-label col-sm-3">Delivery Type:</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="deliveryType" name="deliveryType">
                            <option>Express</option>
                            <option>Economic</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <input type="submit" class="btn btn-success" value="Order"/>
                    </div>
                </div>
            </form>
        </div>
</div>
</main>
