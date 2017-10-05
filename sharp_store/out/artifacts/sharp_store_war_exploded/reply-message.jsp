<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <c:set var="message" value="${message}"/>
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label for="recipient" class="control-label col-sm-3">Recipient</label>
                <div class="col-sm-5">
                    <input type="email" class="form-control" name="recipient"
                           id="recipient" value="${message.sender}" required/>
                </div>
            </div>
            <div class="form-group">
                <label for="subject" class="control-label col-sm-3">Subject</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="subject"
                           id="subject" value="${message.subject}" required/>
                </div>
            </div>
            <div class="form-group">
                <label for="sentMessageContent" class="control-label col-sm-3">Sent Message</label>
                <div class="col-sm-5">
                    <textarea class="form-control" name="sentMessageContent" id="sentMessageContent"
                              rows="4" disabled>${message.content}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="content" class="control-label col-sm-3">Reply Message</label>
                <div class="col-sm-5">
                    <textarea class="form-control" name="content"
                              id="content" rows="4" required>
                    </textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <input type="submit" class="btn btn-primary" value="Reply"/>
                </div>
            </div>
        </form>
    </main>
</div>
