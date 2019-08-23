<jsp:include page="header.jsp"/>
  <div class="wrapper">
       	<jsp:include page="sidenav.jsp"/>
        <div id="content">
           <jsp:include page="navbar.jsp"/>
            <div id="jsGrid"></div>
            <script type="text/javascript">
	            var locations = [
	    			{ Name: "Onsite"},
	    			{ Name: "Offset"},
	    			
	    		];
	    		var projects;
	    		$.ajax({url: "fetchProjects", success: function(result){
	    			projects=result;
	    		}});
	    		$("#jsgrid").jsGrid({
		  			 width: "100%",
		   			height: "400px",
					inserting: true,
		   			editing: true,
		   			sorting: true,
		   		 	autoload: true,
		   			paging: true,
		   			
		   			controller : {
			   			 loadData: function(filter) {
			   				 
			   	          return $.ajax({
			   	              type: "GET",
			   	              url: "fetchProjectConfigConfiguration",
			   	              data: filter
			   	            });
			   	        },
		   				insertItem:function(filter){
		   					return $.ajax({
		   		              type: "GET",
		   		              url: "addProjectConfigThroughAjax",
		   		              data: filter
		   		            });
		   					}
		   			},
		   			fields: [
							{ name: "project.projectname",type: "text",width: 200 , title:"Project"},
							{ name: "role.roleName",title:"Role", type: "text", width: 200 }, 
							{ name: "location", type: "select", items: locations, valueField: "Name", textField: "Name" },
		       				{ name: "perHourBilling", type: "number", width: 200 },
		       				{ type: "control" }		
		   			]
				});
            </script>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>


</html>



    

        