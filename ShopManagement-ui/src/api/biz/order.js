import request from '@/utils/request'

// 查询销售订单列表
export function listOrder(query) {
  return request({
    url: '/biz/order/list',
    method: 'get',
    params: query
  })
}

// 查询销售订单详细
export function getOrder(orderId) {
  return request({
    url: '/biz/order/' + orderId,
    method: 'get'
  })
}

// 查询销售订单详情
export function getOrderDetail(orderId) {
  return request({
    url: '/biz/order/' + orderId,
    method: 'get'
  })
}

// 新增销售订单
export function addOrder(data) {
  return request({
    url: '/biz/order',
    method: 'post',
    data: data
  })
}

// 修改销售订单
export function updateOrder(data) {
  return request({
    url: '/biz/order',
    method: 'put',
    data: data
  })
}

// 删除销售订单
export function delOrder(orderId) {
  return request({
    url: '/biz/order/' + orderId,
    method: 'delete'
  })
}
