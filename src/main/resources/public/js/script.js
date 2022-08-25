$(function () {

    // Start counting from the third row
    var counter=1;
    $("#insertRow").on("click", function (event) {
        event.preventDefault();

//        var previousRow = document.getElementById("productTable").rows.length;

        var newRow = $('<tr id="tableRow'+counter+'">');
        var cols = '';

        // Table columns
        cols += ' <td><select id="mySelect'+counter+'" name="myselect'+counter+'" onchange="myFunction()" class="form-control rounded-0" th:name="|productDtoList['+counter+'].id|"> <option class="form-control">-- Product -----------------------</option> <option th:each="product: *{productList}" th:value="${product.id}" th:text="${product.name}" th:name="|productDtoList['+counter+'].name|">Products</option></select></td>; '
        cols += '<td><input class="form-control rounded-0" type="number" id="price1" name="price1" placeholder="Price" th:name="|productDtoList[1].sellingPrice|" readonly></td>';

        cols += '<td><input class="form-control rounded-0" type="number" id="quantity1" name="quantity1" th:name="|productDtoList[1].quantity|" placeholder="Quantity"></td>';
        cols += '<td><input class="form-control rounded-0" type="number" id="total1" name="total1" placeholder="Total" th:name="|productDtoList[1].amount|" readonly></td><td>';
//        cols += '<td><input class="form-control rounded-0" type="number" name="total1"id="total1" placeholder="total"disabled></td>';
//        cols += '<td><button class="btn btn-danger rounded-0" id ="deleteRow"><i class="fa fa-trash"></i></button></td>';

        console.log(cols)
        // Insert the columns inside a row
        newRow.append(cols);

        // Insert the row inside a table
        $("table").append(newRow);

        // Increase counter after each row insertion
        counter++;
    });

    // Remove row when delete btn is clicked
    $("table").on("click", "#deleteRow", function (event) {
        $(this).closest("tr").remove();
        counter -= 1
    });
});
