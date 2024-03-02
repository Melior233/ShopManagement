import request from '@/utils/request'

// 查询商品收银列表
export function listSaleProduct(query) {
  return request({
    url: '/biz/saleProduct/list',
    method: 'get',
    params: query
  })
}

// 查询商品收银详细
export function getSaleProduct(productId) {
  return request({
    url: '/biz/saleProduct/' + productId,
    method: 'get'
  })
}

// 新增商品收银
export function addSaleProduct(data) {
  return request({
    url: '/biz/saleProduct',
    method: 'post',
    data: data
  })
}

// 修改商品收银
export function updateSaleProduct(data) {
  return request({
    url: '/biz/saleProduct',
    method: 'put',
    data: data
  })
}

// 删除商品收银
export function delSaleProduct(productId) {
  return request({
    url: '/biz/saleProduct/' + productId,
    method: 'delete'
  })
}
