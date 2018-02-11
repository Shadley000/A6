var globalPivotVars = {
    restURL: "http://localhost:51931/InstallationsREST/webapi",
    tableRows: null,
    tableWidth: 0,
    sortMethod: "category" //description, priority, messageType, count
};

function compareRows(row1, row2) {
    if (globalPivotVars.sortMethod == "category") {
        return compareRowsCategorySort(row1, row2);
    } else if (globalPivotVars.sortMethod == "description") {
        return compareRowsDiscriptionSort(row1, row2);
    } else if (globalPivotVars.sortMethod == "priority") {
        return compareRowsPrioritySort(row1, row2);
    } else if (globalPivotVars.sortMethod == "messageType") {
        return compareRowsMessageTypeSort(row1, row2);
    } else if (globalPivotVars.sortMethod == "count") {
        return compareRowsCountSort(row1, row2);
    } else
        return 0;
}

function compareRowsCountSort(row1, row2) {
    if (row1.total < row2.total) {
        return 1;
    } else if (row1.total > row2.total) {
        return -1;
    } else {
        return 0;
    }
}

function compareRowsDiscriptionSort(row1, row2) {
    if (row1.description < row2.description) {
        return -1;
    } else if (row1.description > row2.description) {
        return 1;
    } else {
        return 0;
    }
}

function compareRowsPrioritySort(row1, row2) {
    if (row1.alarmPriority < row2.alarmPriority) {
        return -1;
    } else if (row1.alarmPriority > row2.alarmPriority) {
        return 1;
    } else {
        return 0;
    }
}

function compareRowsMessageTypeSort(row1, row2) {
    if (row1.messageType < row2.messageType) {
        return -1;
    } else if (row1.messageType > row2.messageType) {
        return 1;
    } else {
        return 0;
    }
}

function compareRowsCategorySort(row1, row2) {
    if (row1.system < row2.system) {
        return -1;
    } else if (row1.system > row2.system) {
        return 1;
    } else {
        if (row1.subSystem < row2.subSystem) {
            return -1;
        } else if (row1.subSystem > row2.subSystem) {
            return 1;
        } else {
            if (row1.messageType < row2.messageType) {
                return -1;
            } else if (row1.messageType > row2.messageType) {
                return 1;
            } else {
                if (row1.description < row2.description) {
                    return -1;
                } else if (row1.description > row2.description) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}

function changeSort(e) {
    console.log("changeSort  " + $('[name="sort"]:checked').val());
    globalPivotVars.sortMethod = $('[name="sort"]:checked').val();
    globalPivotVars.tableRows.sort(compareRows);
    displayPivot();
}

function calculateFilter(row){
    if (globalPivotVars.filterMethod == "None")
            row.showMe = true;
        else if (globalPivotVars.filterMethod == "ACS")
            row.showMe = (row.system == "ACS");
        else if (globalPivotVars.filterMethod == "NoACSSDI")
            row.showMe = (row.system != "ACS" && row.system != "SDI" && row.system != "SDI2" );
        else if (globalPivotVars.filterMethod == "LimitCheck")
            row.showMe = true;
}

function changeFilter(e) {
    console.log("changeFilter  " + $('[name="filter"]:checked').val());
    globalPivotVars.filterMethod = $('[name="filter"]:checked').val();

    for (i = 0; i < globalPivotVars.tableRows.length; i++) {
        var row = globalPivotVars.tableRows[i];
        calculateFilter(row);        
    }
    displayPivot();
}

function buildRow(alarmType, histogram) {
    var row = {
        system: "alarmType.system",
        subSystem: "alarmType.subSystem",
        messageType: "alarmType.messageType",
        alarmPriority: "alarmType.alarmPriority",
        tagName: "alarmType.tagName",
        description: "alarmType.description",
        histogram: [],
        total: 0,
        showMe: true
    };
    row.system = alarmType.system;
    row.subSystem = alarmType.subSystem;
    row.messageType = alarmType.messageType;
    row.alarmPriority = alarmType.alarmPriority;
    row.tagName = alarmType.tagName;
    row.description = alarmType.description;
    row.histogram = histogram;
    if (row.histogram.length > globalPivotVars.tableWidth)
        globalPivotVars.tableWidth = row.histogram.length;
    for (column = 0; column < row.histogram.length; column++) {
        row.total += row.histogram[column];
    }
    calculateFilter(row); 
    return row;
}
function loadPivot() {
    console.log("loadPivot");
    if (selectedInstallationID != null) {
        var url = globalPivotVars.restURL + "/installations/" + selectedInstallationID + "/pivot?from=" + $("#pivotStartDate").val() + "&to=" + $("#pivotEndDate").val();
        $.get(url, function (data, status) {
            if (status === "success") {
                globalPivotVars.tableWidth = 0;
                globalPivotVars.tableRows = [];
                for (var key in data) {
                    globalPivotVars.tableRows.push(buildRow(alarmDefinitions[key], data[key]))
                }
                globalPivotVars.tableRows.sort(compareRows);
            } else {
                globalPivotVars.tableWidth = 0;
                globalPivotVars.tableRows = null;
                console.log("loadPivot() failed");
            }
            displayPivot();
        });
    } else
        console.log("loadPivot() selectedInstallationID != undefined");
}
function displayPivot() {
    console.log("displayPivot");
    console.log("hideSystem:" + !$('[name="hideSystem"]').is(":checked"));
    var text = "";
    if (globalPivotVars.tableRows != null) {
        text += "<TABLE>";
        text += "<TR>";
        if ($('[name="showSystem"]').is(":checked"))
            text += "<TH>System</TH>";
        if ($('[name="showSubSystem"]').is(":checked"))
            text += "<TH>SubSystem</TH>";
        if ($('[name="showMessageType"]').is(":checked"))
            text += "<TH>Type</TH>";
        if ($('[name="showPriority"]').is(":checked"))
            text += "<TH>Priority</TH>";
        if ($('[name="showTagName"]').is(":checked"))
            text += "<TH>TagName</TH>";
        if ($('[name="showDescription"]').is(":checked"))
            text += "<TH>Description</TH>";
        if ($('[name="showHistogram"]').is(":checked")) {
            var starttime = Date.parse($("#pivotStartDate").val());
            for (col = 0; col < globalPivotVars.tableWidth; col++) {
                var columnTime = new Date(starttime + (col * 1000 * 60 * 60 * 24));
                text += "<TH>" + columnTime.getFullYear() + "-" + (columnTime.getMonth() + 1) + "-" + columnTime.getDate() + "</TH>";
            }
        }
        if ($('[name="showTotal"]').is(":checked"))
            text += "<TH>Total</TH>";
        text += "</TR>";

        for (i = 0; i < globalPivotVars.tableRows.length; i++) {
            var row = globalPivotVars.tableRows[i];
            if (row.showMe) {
                text += "<TR>"
                if ($('[name="showSystem"]').is(":checked"))
                    text += "<TD>" + row.system + "</TD>";
                if ($('[name="showSubSystem"]').is(":checked"))
                    text += "<TD>" + row.subSystem + "</TD>";
                if ($('[name="showMessageType"]').is(":checked"))
                    text += "<TD>" + row.messageType + "</TD>";
                if ($('[name="showPriority"]').is(":checked"))
                    text += "<TD>" + row.alarmPriority + "</TD>";
                if ($('[name="showTagName"]').is(":checked"))
                    text += "<TD>" + row.tagName + "</TD>";
                if ($('[name="showDescription"]').is(":checked"))
                    text += "<TD>" + row.description + "</TD>";
                var histogram = row.histogram;
                if ($('[name="showHistogram"]').is(":checked") && histogram != null) {
                    for (column = 0; column < histogram.length; column++) {
                        text += "<TD>";
                        text += histogram[column];
                        text += "</TD>";
                    }
                }
                if ($('[name="showTotal"]').is(":checked"))
                    text += "<TH>" + row.total + "</TH>";
                text += "</TR>";
            }
        }
        text += "</TABLE>";
    } else {
        text += "No Alarm Pivot Loaded";
    }
    $("#alarmPivotTable").html(text);
}
function displayPivotPage() {
    console.log("displayPivotPage");
    var text = "<h1>Pivot</h1>";
    text += "<ul>";
    text += "<li >Start Date <input type='text' name='pivotStartDate' id ='pivotStartDate' value='2018-01-01' /></li>";
    text += "<li >End Date <input type='text' name='pivotEndDate' id ='pivotEndDate' value='2018-01-31' /></li>";
    text += "<li ><button id='button_loadAlarmPivot' >Load</button></li>";
    text += "<li >"
    text += "<input type='checkbox' name='showSystem' checked>System </input>";
    text += "<input type='checkbox' name='showSubSystem' checked>SubSystem </input>";
    text += "<input type='checkbox' name='showMessageType' checked>Type </input>";
    text += "<input type='checkbox' name='showPriority' checked>Priority </input>";
    text += "<input type='checkbox' name='showTagName' checked>TagName </input>";
    text += "<input type='checkbox' name='showDescription' checked>Description</input>";
    text += "<input type='checkbox' name='showHistogram' checked>Histogram</input>";
    text += "<input type='checkbox' name='showTotal' checked>Total </input>"
    text += "</li>";
    text += "<li >";
    text += "<input type='radio' name='sort' value='category' checked> category</input>";
    text += "<input type='radio' name='sort' value='description'> description</input>";
    text += "<input type='radio' name='sort' value='priority'> priority</input>";
    text += "<input type='radio' name='sort' value='messageType'> messageType</input>";
    text += "<input type='radio' name='sort' value='count'> count</input>";
    text += "</li>";
    text += "<li >";
    text += "<input type='radio' name='filter' value='None' checked> None</input>";
    text += "<input type='radio' name='filter' value='ACS' > ACS Only</input>";
    text += "<input type='radio' name='filter' value='NoACSSDI' > Exclude ACS & SDI</input>";
    text += "<input type='radio' name='filter' value='LimitCheck' > Limit Checks</input>";
    text += "<input type='radio' name='filter' value='SDI' > Interlock Override</input>";
    text += "</li>";

    text += "<li  id='alarmPivotTable'></li>";

    $("#div_report").html(text);
    $("#button_loadAlarmPivot").click(loadPivot);

    $('[name="sort"]').on('click change', changeSort);
    $('[name="filter"]').on('click change', changeFilter);

    $('[name="showSystem"]').on('click change', displayPivot);
    $('[name="showSubSystem"]').on('click change', displayPivot);
    $('[name="showMessageType"]').on('click change', displayPivot);
    $('[name="showPriority"]').on('click change', displayPivot);
    $('[name="showTagName"]').on('click change', displayPivot);
    $('[name="showDescription"]').on('click change', displayPivot);
    $('[name="showHistogram"]').on('click change', displayPivot);
    $('[name="showTotal"]').on('click change', displayPivot);

}

$(document).ready(function () {
    $("#button_AlarmPivotPage").click(displayPivotPage);
});
