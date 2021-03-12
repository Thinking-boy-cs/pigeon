<template>
  <div>
    <div class="header-title">
      <a-icon class="smile" type="smile" />请选择合适的订购计划
    </div>
    <div>
      <a-row>
        <a-col :span="8">
          <div class="first">
            <div class="price-title">普通版</div>
            <div>
              <div class="price">¥1999</div>
              <div class="price1">每月</div>
              <div class="intro">
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />基本的管理功能
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="close-circle"
                    theme="twoTone"
                    two-tone-color="#fc544b"
                  />多层级的公司架构管理
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />管理人数上限100
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />12h人工客服在线咨询
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="close-circle"
                    theme="twoTone"
                    two-tone-color="#fc544b"
                  />提供企业数据可视化决策
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />最多可支持设置3个次级管理员
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="close-circle"
                    theme="twoTone"
                    two-tone-color="#fc544b"
                  />VIP专线
                </div>
              </div>
            </div>
          </div>
          <a-button class="button" type="primary"> 去订购 </a-button>
        </a-col>
        <a-col :span="8">
          <div class="second">
            <div class="price-title">进阶版</div>
            <div>
              <div class="price">¥3999</div>
              <div class="price1">每月</div>
              <div class="intro">
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />基本的管理功能
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />多层级的公司架构管理
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />管理人数上限500
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />12h人工客服在线咨询
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="close-circle"
                    theme="twoTone"
                    two-tone-color="#fc544b"
                  />提供企业数据可视化决策
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />最多可支持设置5个次级管理员
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="close-circle"
                    theme="twoTone"
                    two-tone-color="#fc544b"
                  />VIP专线
                </div>
              </div>
            </div>
          </div>
          <a-button class="button" type="primary"> 去订购 </a-button>
        </a-col>
        <a-col :span="8">
          <div class="third">
            <div class="price-title">至尊版</div>
            <div>
              <div class="price">¥6999</div>
              <div class="price1">每月</div>
              <div class="intro">
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />基本的管理功能
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />多层级的公司架构管理
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />管理人数上限1000
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />24h人工客服在线咨询
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />提供企业数据可视化决策
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />最多可支持设置7个次级管理员
                </div>
                <div class="item">
                  <a-icon
                    class="icon"
                    type="check-circle"
                    theme="twoTone"
                    two-tone-color="#52c41a"
                  />VIP专线
                </div>
              </div>
            </div>
          </div>
          <a-button class="button" type="primary"> 去订购 </a-button>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.smile {
  font-size: 25px;
  color: "#08c";
  font-weight: bolder;
  margin-right: 15px;
}
.header-title {
  font-size: 20px;
  font-family: PingFang SC;
  font-weight: bold;
}
.price {
  font-weight: 600;
  font-size: 50px;
  text-align: center;
  font-family: "Nunito", "Segoe UI", arial;
}
.price1 {
  font-size: 20px;
  color: #6c757d;
  margin-bottom: 30px;
}
.price-title {
  font-size: 10px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  background-color: #6777ef;
  color: #fff;
  border-radius: 0 0 3px 3px;
  display: inline-block;
  padding: 5px 15px;
}
.intro {
  font-size: 18px;
  font-family: "Nunito", "Segoe UI", arial;
  color: #6c757d;
  text-align: left;
  display: inline-block;
}
.first {
  margin-top: 30px;
  height: 60vh;
  width: 40vh;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.03);
  border-radius: 3px;
  background-color: #fff;
}
.second {
  margin-top: 30px;
  height: 60vh;
  width: 40vh;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.03);
  border-radius: 3px;
  background-color: #fff;
}
.third {
  margin-top: 30px;
  height: 60vh;
  width: 40vh;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.03);
  border-radius: 3px;
  background-color: #fff;
}
.icon {
  width: 20px;
  height: 20px;
  line-height: 20px;
  border-radius: 50%;
  text-align: center;
  margin-right: 10px;
}
.item {
  margin-bottom: 10px;
}
.button {
  width: 40vh;
  height: 6vh;
}
</style>
