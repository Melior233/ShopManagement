import request from '@/utils/request'

// 查询商铺通知列表
export function listNotifications(query) {
  return request({
    url: '/system/notifications/list',
    method: 'get',
    params: query
  })
}

// 查询商铺通知详细
export function getNotifications(id) {
  return request({
    url: '/system/notifications/' + id,
    method: 'get'
  })
}

// 新增商铺通知
export function addNotifications(data) {
  return request({
    url: '/system/notifications',
    method: 'post',
    data: data
  })
}

// 修改商铺通知
export function updateNotifications(data) {
  return request({
    url: '/system/notifications',
    method: 'put',
    data: data
  })
}

// 删除商铺通知
export function delNotifications(id) {
  return request({
    url: '/system/notifications/' + id,
    method: 'delete'
  })
}
