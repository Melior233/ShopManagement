<template>
  <div class="app-container">
    <div id="main" style="width: 500px; height: 500px"></div>
    <div id="main2" style="width: 500px; height: 500px"></div>
  </div>
</template>


<script>
import * as echarts from 'echarts';

export default {
  name: "Detail",
  data() {
    return {
        xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    series: [
        {
        data: [150, 230, 224, 218, 135, 147, 260],
        type: 'line'
        },
    ],
    }
  },
  created() {
    this.series[0].data = [999, 230, 224, 218, 135, 147, 260]
  },
  mounted () {
    this.init(),
    this.init2()
  },
  methods: {
    init() {
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
    xAxis: this.xAxis,
    yAxis: {
        type: 'value'
    },
    series: this.series
    };

    option && myChart.setOption(option);
    },init2() {
    var chartDom = document.getElementById('main2');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
    xAxis: this.xAxis,
    yAxis: {
        type: 'value'
    },
    series: this.series
    };

    option && myChart.setOption(option);
    }

  }
};
</script>
