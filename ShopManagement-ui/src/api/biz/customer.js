import request from '@/utils/request'

// 查询VIP客户信息列表
export function listCustomer(query) {
  return request({
    url: '/biz/customer/list',
    method: 'get',
    params: query
  })
}

// 查询VIP客户信息详细
export function getCustomer(vipCustomerId) {
  return request({
    url: '/biz/customer/' + vipCustomerId,
    method: 'get'
  })
}

// 新增VIP客户信息
export function addCustomer(data) {
  return request({
    url: '/biz/customer',
    method: 'post',
    data: data
  })
}

// 修改VIP客户信息
export function updateCustomer(data) {
  return request({
    url: '/biz/customer',
    method: 'put',
    data: data
  })
}

// 删除VIP客户信息
export function delCustomer(vipCustomerId) {
  return request({
    url: '/biz/customer/' + vipCustomerId,
    method: 'delete'
  })
}
