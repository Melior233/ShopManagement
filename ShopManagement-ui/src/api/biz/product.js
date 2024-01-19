import request from '@/utils/request'

// 查询商品信息管理列表
export function listProduct(query) {
  return request({
    url: '/biz/product/list',
    method: 'get',
    params: query
  })
}

// 查询商品信息管理详细
export function getProduct(productId) {
  return request({
    url: '/biz/product/' + productId,
    method: 'get'
  })
}

// 新增商品信息管理
export function addProduct(data) {
  return request({
    url: '/biz/product',
    method: 'post',
    data: data
  })
}

// 修改商品信息管理
export function updateProduct(data) {
  return request({
    url: '/biz/product',
    method: 'put',
    data: data
  })
}

// 删除商品信息管理
export function delProduct(productId) {
  return request({
    url: '/biz/product/' + productId,
    method: 'delete'
  })
}
