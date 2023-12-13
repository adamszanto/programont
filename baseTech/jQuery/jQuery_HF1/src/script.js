$(document).ready(jOnReady);

function jOnReady(ev) {
    console.log("jQuery ready");

    var countries = [
        {
            id: 1,
            name: "Marocco",
            population: 130000
        },
        {
            id: 2,
            name: "Hungary",
            population: 150000
        }
    ];

    function appendToCountryTable(country) {
        var countryTable = $("#countryTable");
        var newRow = $("<div class='table-row'></div>");

        newRow.append("<div class='table-col table-col-name'>" + country.name + "</div>");
        newRow.append("<div class='table-col table-col-population'>" + country.population + "</div>");
        newRow.append("<div class='table-col'><button>Edit</button></div>");
        newRow.append("<div class='table-col'><button class='delete-button' data-country-id='" + country.id + "'>Remove</button></div>");

        countryTable.append(newRow);
    }

    $.each(countries, function (i, country) {
        appendToCountryTable(country);
    });

    $("form").submit(function (e) {
        e.preventDefault();
    });

    $("form#addCountry").submit(function () {
        var country = {};
        var nameInput = $('input[name="name"]').val().trim();
        var populationInput = $('input[name="population"]').val().trim();

        if (nameInput && populationInput) {
            country.name = nameInput;
            country.population = populationInput;

            var lastCountry = countries[countries.length - 1];
            country.id = lastCountry.id + 1;

            addCountry(country);
        }
    });

    $("#countryTable").on("click", ".delete-button", function () {
        var countryId = $(this).data("country-id");
        deleteCountry(countryId);
    });

    function addCountry(country) {
        countries.push(country);
        appendToCountryTable(country);
    }

    function deleteCountry(id) {
        countries.forEach(function (country,i ) {
               countries.splice(i, 1);
               $("#countryTable #country-" + country.id).remove();
        });
    }
}
