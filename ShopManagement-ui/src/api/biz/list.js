import request from '@/utils/request'

// 查询入库清单管理列表
export function listList(query) {
  return request({
    url: '/biz/list/list',
    method: 'get',
    params: query
  })
}

// 查询入库清单管理详细
export function getList(inboundListId) {
  return request({
    url: '/biz/list/' + inboundListId,
    method: 'get'
  })
}

// 新增入库清单管理
export function addList(data) {
  return request({
    url: '/biz/list',
    method: 'post',
    data: data
  })
}

// 修改入库清单管理
export function updateList(data) {
  return request({
    url: '/biz/list',
    method: 'put',
    data: data
  })
}

// 删除入库清单管理
export function delList(inboundListId) {
  return request({
    url: '/biz/list/' + inboundListId,
    method: 'delete'
  })
}
