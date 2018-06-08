require(["d3", "forceDirectedGraph", "lodash"], function (d3, ForceDirectedGraph, lodash) {

    // Initialize the force directed graph.
    var container = d3.select("#container").node(),
        forceDirectedGraph = ForceDirectedGraph({ container: container });
  
    // Initialize zoom based on client size.
    var scale = container.clientWidth * 1 / 800;
    forceDirectedGraph.scale = scale;
    forceDirectedGraph.translate = [
      container.clientWidth / 2 * (1 - scale),
      container.clientHeight / 2 * (1 - scale)
    ];

   

    // Set up default data.
    if(!window.localStorage.getItem("data")){
      // location.hash = '{"nodes":[{"type":"lambda","fixed":1,"x":-108,"y":308},{"type":"property","property":"container","fixed":1,"x":-233,"y":306},{"type":"property","property":"svg","fixed":1,"x":-5,"y":309},{"type":"lambda","fixed":1,"x":214,"y":176},{"type":"property","property":"box","fixed":1,"x":-200,"y":257},{"type":"lambda","fixed":1,"x":80,"y":311},{"type":"property","property":"g","fixed":1,"x":165,"y":311},{"type":"lambda","fixed":1,"x":212,"y":264},{"type":"property","property":"margin","fixed":1,"x":-222,"y":202},{"type":"lambda","fixed":1,"x":231,"y":369},{"type":"property","property":"titleText","fixed":1,"x":388,"y":347},{"type":"lambda","fixed":1,"x":578,"y":391},{"type":"property","property":"titleOffset","fixed":1,"x":430,"y":401},{"type":"lambda","fixed":1,"x":214,"y":216},{"type":"property","property":"width","fixed":1,"x":497,"y":63},{"type":"property","property":"height","fixed":1,"x":485,"y":555},{"type":"lambda","fixed":1,"x":653,"y":123},{"type":"property","property":"xAxisG","fixed":1,"x":782,"y":65},{"type":"property","property":"xAxisText","fixed":1,"x":785,"y":119},{"type":"lambda","fixed":1,"x":963,"y":159},{"type":"property","property":"xAxisLabelOffset","fixed":1,"x":-292,"y":153},{"type":"lambda","fixed":1,"x":955,"y":53},{"type":"lambda","fixed":1,"x":963,"y":107},{"type":"lambda","fixed":1,"x":963,"y":221},{"type":"property","property":"xAxisLabel","fixed":1,"x":-257,"y":104},{"type":"lambda","fixed":1,"x":598,"y":332},{"type":"property","property":"yAxisG","fixed":1,"x":811,"y":442},{"type":"property","property":"yAxisText","fixed":1,"x":790,"y":390},{"type":"lambda","fixed":1,"x":946,"y":335},{"type":"property","property":"yAxisLabelOffset","fixed":1,"x":-286,"y":418},{"type":"lambda","fixed":1,"x":946,"y":463},{"type":"lambda","fixed":1,"x":944,"y":407},{"type":"property","property":"yAxisLabel","fixed":1,"x":-248,"y":466},{"type":"lambda","fixed":1,"x":674,"y":271},{"type":"property","property":"barsG","fixed":1,"x":1133,"y":312},{"type":"lambda","fixed":1,"x":589,"y":235},{"type":"lambda","fixed":true,"x":-87,"y":137},{"type":"property","property":"data","fixed":1,"x":-203,"y":365},{"type":"property","property":"xAttribute","fixed":1,"x":-242,"y":54},{"type":"property","property":"getX","fixed":1,"x":147,"y":92},{"type":"lambda","fixed":1,"x":17,"y":26},{"type":"property","property":"sortField","fixed":1,"x":-234,"y":2},{"type":"property","property":"sortOrder","fixed":1,"x":-235,"y":-51},{"type":"property","property":"sortedData","fixed":1,"x":157,"y":17},{"type":"lambda","fixed":1,"x":-70,"y":499},{"type":"property","property":"yAttribute","fixed":1,"x":-233,"y":521},{"type":"property","property":"getY","fixed":1,"x":61,"y":525},{"type":"lambda","fixed":1,"x":281,"y":585},{"type":"property","property":"yDomainMin","fixed":1,"x":-252,"y":573},{"type":"property","property":"yDomainMax","fixed":1,"x":-255,"y":625},{"type":"property","property":"yDomain","fixed":1,"x":475,"y":614},{"type":"lambda","fixed":1,"x":678,"y":566},{"type":"property","property":"yScale","fixed":1,"x":815,"y":565},{"type":"lambda","fixed":1,"x":1033,"y":516},{"type":"property","property":"getYScaled","fixed":1,"x":1243,"y":482},{"type":"lambda","fixed":1,"x":326,"y":4},{"type":"property","property":"xDomain","fixed":1,"x":498,"y":-11},{"type":"lambda","fixed":1,"x":952,"y":573},{"type":"lambda","fixed":1,"x":668,"y":-27},{"type":"property","property":"barPadding","fixed":1,"x":-248,"y":-101},{"type":"property","property":"xScale","fixed":1,"x":787,"y":0},{"type":"lambda","fixed":1,"x":1092,"y":96},{"type":"property","property":"getXScaled","fixed":1,"x":1233,"y":131},{"type":"lambda","fixed":1,"x":955,"y":-2},{"type":"lambda","fixed":1,"x":1378,"y":318}],"links":[{"source":1,"target":0},{"source":0,"target":2},{"source":2,"target":3},{"source":4,"target":3},{"source":2,"target":5},{"source":5,"target":6},{"source":6,"target":7},{"source":8,"target":7},{"source":6,"target":9},{"source":9,"target":10},{"source":10,"target":11},{"source":12,"target":11},{"source":4,"target":13},{"source":8,"target":13},{"source":13,"target":14},{"source":13,"target":15},{"source":6,"target":16},{"source":16,"target":17},{"source":16,"target":18},{"source":18,"target":19},{"source":20,"target":19},{"source":17,"target":21},{"source":15,"target":21},{"source":18,"target":22},{"source":14,"target":22},{"source":18,"target":23},{"source":24,"target":23},{"source":6,"target":25},{"source":25,"target":26},{"source":25,"target":27},{"source":27,"target":28},{"source":29,"target":28},{"source":27,"target":30},{"source":15,"target":30},{"source":27,"target":31},{"source":32,"target":31},{"source":6,"target":33},{"source":33,"target":34},{"source":10,"target":35},{"source":14,"target":35},{"source":37,"target":36},{"source":38,"target":36},{"source":36,"target":39},{"source":41,"target":40},{"source":42,"target":40},{"source":37,"target":40},{"source":40,"target":43},{"source":37,"target":44},{"source":45,"target":44},{"source":44,"target":46},{"source":37,"target":47},{"source":46,"target":47},{"source":48,"target":47},{"source":49,"target":47},{"source":47,"target":50},{"source":37,"target":51},{"source":50,"target":51},{"source":15,"target":51},{"source":51,"target":52},{"source":37,"target":53},{"source":52,"target":53},{"source":46,"target":53},{"source":53,"target":54},{"source":43,"target":55},{"source":39,"target":55},{"source":55,"target":56},{"source":26,"target":57},{"source":52,"target":57},{"source":56,"target":58},{"source":14,"target":58},{"source":59,"target":58},{"source":58,"target":60},{"source":37,"target":61},{"source":60,"target":61},{"source":39,"target":61},{"source":61,"target":62},{"source":17,"target":63},{"source":60,"target":63},{"source":34,"target":64},{"source":43,"target":64},{"source":62,"target":64},{"source":54,"target":64},{"source":60,"target":64},{"source":15,"target":64}],"scale":0.5332125839901604,"translate":[373.3250529749264,143.7733216449567]}';
      window.localStorage.setItem("data", data);
    }
  
    // Update the fragment identifier in response to user interactions.
    forceDirectedGraph.when(["state"], function(state){
      // location.hash = JSON.stringify(state);
      window.localStorage.setItem("data", JSON.stringify(state));
      console.log('state change');
    });
    
    // Sets the data on the graph visualization from the fragment identifier.
    // See https://github.com/curran/screencasts/blob/gh-pages/navigation/examples/code/snapshot11/main.js
    function navigate(){
      if(window.localStorage.getItem("data")){
        var newState = JSON.parse(window.localStorage.getItem("data"));
        if(JSON.stringify(newState) !== JSON.stringify(forceDirectedGraph.state)){
          forceDirectedGraph.state = newState;
        }
      }
    }
  
    // Navigate once to the initial hash value.
    navigate();
    
    // Navigate whenever the fragment identifier value changes.
    window.addEventListener("storage", navigate);
  
    // Sets the `box` model property
    // based on the size of the container,
    function computeBox(){
      forceDirectedGraph.box = {
        width: container.clientWidth,
        height: container.clientHeight
      };
    }
  
    // once to initialize `model.box`, and
    computeBox();
  
    // whenever the browser window resizes in the future.
    window.addEventListener("resize", computeBox);

    
    
  });