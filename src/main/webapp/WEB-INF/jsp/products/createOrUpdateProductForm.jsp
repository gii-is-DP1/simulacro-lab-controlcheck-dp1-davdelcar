<%@ page session="false" trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

                    <petclinic:layout pageName="owners">
                        <jsp:attribute name="customScript">
                        </jsp:attribute>
                        <jsp:body>
                            <form:form modelAttribute="product" class="form-horizontal">
                                <petclinic:inputField label="Name" name="name" />
                                <petclinic:inputField label="Price" name="price" />
                                <div class="control-group">
                                    <petclinic:selectField name="ProductType" label="Type " names="${product_types}"
                                        size="5" />
                                </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button class="btn btn-default" type="submit">Add Product</button>
                                    </div>
                                </div>
                            </form:form>
                        </jsp:body>
                    </petclinic:layout>