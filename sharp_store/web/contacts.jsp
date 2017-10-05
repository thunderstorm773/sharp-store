<div class="container">
    <main>
        <div class="row">
            <div class="jumbotron">
                <form method="post" class="form-horizontal">
                    <div class="form-group">
                        <label for="sender" class="control-label col-sm-3">Your Email:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="email" id="sender" name="sender" class="form-control col-sm-3"
                                       placeholder="Enter your email..." required/>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subject" class="control-label col-sm-3">Subject:</label>
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" id="subject" name="subject" class="form-control"
                                       placeholder="Enter subject..." required/>
                                <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="control-label col-sm-3">Message:</label>
                        <div class="col-sm-5">
                <textarea id="content" name="content" class="form-control"
                          placeholder="Enter your message..." rows="4" required></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-5 col-sm-offset-3">
                            <input type="reset" class="btn btn-danger" value="Clear"/>
                            <input type="submit" class="btn btn-primary" value="Send"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>