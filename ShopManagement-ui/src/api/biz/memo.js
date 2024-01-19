import request from '@/utils/request'

// 查询备忘录信息列表
export function listMemo(query) {
  return request({
    url: '/biz/memo/list',
    method: 'get',
    params: query
  })
}

// 查询备忘录信息详细
export function getMemo(memoId) {
  return request({
    url: '/biz/memo/' + memoId,
    method: 'get'
  })
}

// 新增备忘录信息
export function addMemo(data) {
  return request({
    url: '/biz/memo',
    method: 'post',
    data: data
  })
}

// 修改备忘录信息
export function updateMemo(data) {
  return request({
    url: '/biz/memo',
    method: 'put',
    data: data
  })
}

// 删除备忘录信息
export function delMemo(memoId) {
  return request({
    url: '/biz/memo/' + memoId,
    method: 'delete'
  })
}
